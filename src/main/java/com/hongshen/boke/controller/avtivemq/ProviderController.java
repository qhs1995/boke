package com.hongshen.boke.controller.avtivemq;

import com.hongshen.boke.dao.object.ArticleDO;
import com.hongshen.boke.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.jms.Queue;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/7/1 14:46
 * @Desc: activemq生产者
 */
@Controller
@RequestMapping("activemq")
public class ProviderController {
    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    /**
     * http://47.99.218.155:8161/admin/queues.jsp
     * admin
     * admin
     * @return
     */
    @RequestMapping("send")
    @ResponseBody
    public String send(){
        ArticleDO aDo = new ArticleDO();
        aDo.setTitle("文章名称");
        aDo.setDescription("文章描述");
        String string = JsonUtil.toJson(aDo);
        messagingTemplate.convertAndSend(queue,string);
        // 使用此种方式 系统默认会创建一个test的消息队列
        //  messagingTemplate.convertAndSend("test","嘿嘿");
        return "success";
    }

}
