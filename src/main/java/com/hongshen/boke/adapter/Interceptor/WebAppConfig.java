//package com.hongshen.boke.adapter.Interceptor;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IDEA
// *
// * @author:qianhongshen
// * @Date:2018/11/7 17:05
// * @Desc: 注册拦截器
// */
//@Configuration
//public class WebAppConfig extends WebMvcConfigurerAdapter {
//    private static final Logger logger = LoggerFactory.getLogger(WebAppConfig.class);
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册自定义拦截器，添加拦截路径和排除拦截路径
//        List<String> list=new ArrayList<>();
//        list.add("/manager/logins.html");
//        list.add("/manager/login.html");
//        list.add("/manager/redis.html");
//        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**/*.html").excludePathPatterns(list);
//    }
//
//}
