package com.hongshen.boke.jianli.service.impl;

import com.hongshen.boke.jianli.service.SendEmailService;
import com.hongshen.boke.request.email.EmailRequest;
import com.hongshen.boke.utils.JsonUtil;
import com.hongshen.boke.utils.SendMailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/24 17:04
 * @Desc:
 */
@Service
public class SendEmailImpl implements SendEmailService {
    private static final Logger logger = LoggerFactory.getLogger(SendEmailImpl.class);

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void send(String json) {
        messagingTemplate.convertAndSend("email",json);
    }

    @JmsListener(destination = "email")
    @SendTo("handle")
    public void handleMessage(String json){
        EmailRequest aDo = JsonUtil.parseJson(json, EmailRequest.class);
        SendMailUtil.send(aDo.getContent(),aDo.getName());
        logger.info("发送邮件成功，发送人={}",aDo.getName());
    }
}
