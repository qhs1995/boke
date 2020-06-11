package com.hongshen.boke.controller.avtivemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/7/1 14:44
 * @Desc:
 */
@Configuration
public class BeanConfig {
    private static final Logger logger = LoggerFactory.getLogger(BeanConfig.class);

    /**
     * 定义存放消息的队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("testQueue");
    }

}
