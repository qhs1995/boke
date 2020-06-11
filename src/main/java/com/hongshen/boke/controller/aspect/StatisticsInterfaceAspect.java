package com.hongshen.boke.controller.aspect;

import com.hongshen.boke.dao.jianli.mapper.StatisticsMapper;
import com.hongshen.boke.dao.jianli.object.StatisticsDO;
import com.hongshen.boke.dao.jianli.object.StatisticsExample;
import com.hongshen.boke.request.email.EmailRequest;
import com.hongshen.boke.utils.IpUtils;
import com.hongshen.boke.utils.JsonUtil;
import com.hongshen.boke.utils.SendMailUtil;
import com.hongshen.boke.utils.TimeOperationUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/24 15:14
 * @Desc: 接口访问拦截统计
 */
@Order(2)
@Aspect
@Component
public class StatisticsInterfaceAspect {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsInterfaceAspect.class);

    @Autowired
    private StatisticsMapper statisticsMapper;
    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Pointcut("execution(* com.hongshen.boke.controller.before.*Controller.*(..)) || execution(* com.hongshen.boke.jianli.controller.before.*Controller.*(..))")
    public void poincut(){}


    /**
     * 接口访问统计  （博客相关统计）
     * @param jp
     */
    @Before("poincut()")
    public void before(JoinPoint jp){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = IpUtils.getIp();
        StatisticsDO aDo = new StatisticsDO();
        aDo.setIp(ip);
        aDo.setInterfaceName(request.getRequestURI());
        messagingTemplate.convertAndSend("count",JsonUtil.toJson(aDo));
    }

    @JmsListener(destination = "count")
    @SendTo("handle")
    public void handleMessage(String json){
        StatisticsDO aDo = JsonUtil.parseJson(json, StatisticsDO.class);
        insertStatisticsLog(aDo.getIp(),aDo.getInterfaceName());
    }

    public void insertStatisticsLog(String ip,String methodName){
        StatisticsExample example = new StatisticsExample();
        example.createCriteria().andIpEqualTo(ip).andInterfaceNameEqualTo(methodName);
        List<StatisticsDO> list = statisticsMapper.selectByExample(example);
        if (list.size() == 0){
            StatisticsDO aDo = new StatisticsDO();
            aDo.setIp(ip);
            aDo.setInterfaceName(methodName);
            aDo.setCount(1);
            statisticsMapper.insertSelective(aDo);
        }else {
            StatisticsDO aDo = list.get(0);
            //五分钟内是否已经发送过邮件
            Date time = TimeOperationUtils.operation(new Date(), Calendar.MINUTE, -5);
            if (aDo.getUpdateTime().after(time) && "/jianli/sendEmail".equals(aDo.getInterfaceName())){
                return;
            }
            aDo.setCount(aDo.getCount()+1);
            aDo.setUpdateTime(new Date());
            statisticsMapper.updateByPrimaryKeySelective(aDo);
        }
    }


//    @Around("poincut()")
//    public Object controllerLog(ProceedingJoinPoint pdj) throws Throwable{
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        long startTime = System.currentTimeMillis();//开始时间
//
//        Object[] args = pdj.getArgs();//获取参数数组
//        Object ret = pdj.proceed(args);//执行原方法并获取返回结果
//
//        long endTime = System.currentTimeMillis();//结束时间
//
//        // 记录下请求内容
//        StringBuilder sb = new StringBuilder();
//        sb.append("###请求URL: " + request.getRequestURL().toString());
//        sb.append("   ###IP: " + request.getRemoteAddr());
//        sb.append("   ###Params: " + Arrays.toString(args));
//        sb.append("   ###CLASS_METHOD: " + pdj.getSignature().getDeclaringTypeName() + "." + pdj.getSignature().getName());
//        sb.append("   ###耗时: " + (endTime - startTime) + "毫秒");
//
//        logger.info(sb.toString());
//        return ret;
//    }
}
