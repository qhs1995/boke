package com.hongshen.boke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

/**
 * @author qianhongshen
 */
@SpringBootApplication
@MapperScan("com.hongshen.boke.dao.**")
@EnableScheduling
@EnableJms  //启动消息队列（activemq）
public class BokeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BokeApplication.class, args);
        String[] profiles = applicationContext.getEnvironment().getActiveProfiles();
        String port = applicationContext.getEnvironment().getProperty("server.port");
        System.out.println("运行环境为："+ Arrays.toString(profiles));
        System.out.println("系统启动成功，点击：http://127.0.0.1:"+port+"/manager/login.html  访问后台");
        System.out.println("系统启动成功，点击：http://127.0.0.1:"+port+"/boke.html  访问博客");
       // System.out.println("系统启动成功，点击：http://127.0.0.1:"+port+"  访问简历");
    }
}
