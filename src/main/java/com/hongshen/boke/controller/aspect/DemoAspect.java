package com.hongshen.boke.controller.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/6/25 17:27
 * @Desc: 切面测试类 （需导入aspectj依赖）
 */

//order指定切面的优先级 里面的数值越小 优先级越高
@Order(1)
@Aspect
@Component
public class DemoAspect {


    //pointcut 可以重用切点表达式  当多个before或多个after等情况的切面相同时 则可以用此注解进行重用
    @Pointcut("execution(* com.hongshen.boke.controller.*Controller.*(..))")
    public void poincut(){}


    //前置通知  进入方法之前执行 execution表示要执行的方法或类   @annotation使用注解方式标注的方法或类
    @Before("poincut()")
    public void before(JoinPoint jp){
        System.out.println("我是前置");
    }

    //后置通知  方法执行完之后执行  注意：无论方法是否抛出异常，都会执行后置通知
    @After(value = "execution(* com.hongshen.boke.controller.ArticleController.list(..))" )
    public void afterMethod(){
        System.out.println("我是后置");
    }


    //返回通知（后置通知执行之后执行  方法正常结束时执行）  进入方法之后执行
    // JoinPoint 可获得一些请求数据 如请求方法名等  Object -->result 执行完方法后返回的数据
    @AfterReturning(value = "execution(* com.hongshen.boke.controller.ArticleController.list(..))", returning = "result")
    public void afterMethod(JoinPoint jp,Object result){
        //请求方法名
        String methodName = jp.getSignature().getName();
        //请求参数
        Object[] args = jp.getArgs();

    }


    //异常通知  出现异常时执行  可以指定异常进行捕获 （如果要指定异常则把Exception改成对应的异常类型）
    @AfterThrowing(value = "execution(* com.hongshen.boke.controller.ArticleController.list(..))",throwing = "ex")
    public void afterThrowing(JoinPoint jp,Exception ex){
        System.out.println(ex);
    }


    //环绕通知
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
//        return ret;
//    }

}
