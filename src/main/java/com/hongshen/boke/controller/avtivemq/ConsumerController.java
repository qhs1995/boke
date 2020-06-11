package com.hongshen.boke.controller.avtivemq;

import com.hongshen.boke.dao.object.ArticleDO;
import com.hongshen.boke.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/7/1 15:04
 * @Desc: avtivemq消费者
 */
@Controller
public class ConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);


    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    //JmsListener 监听队列 testQueue 监听的队列名称
    @JmsListener(destination = "testQueue")
    @SendTo("handle")
    public String handleMessage(String name){
        ArticleDO aDo = JsonUtil.parseJson(name, ArticleDO.class);
        System.out.println("接受到："+aDo);
        return name;
    }
}
