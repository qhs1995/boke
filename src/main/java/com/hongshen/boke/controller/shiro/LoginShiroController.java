//package com.hongshen.boke.controller.shiro;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created with IDEA
// *
// * @author:qianhongshen
// * @Date:2019/7/8 13:06
// * @Desc:
// */
//@RestController
//public class LoginShiroController {
//    private static final Logger logger = LoggerFactory.getLogger(LoginShiroController.class);
//
//    /**
//     * 登陆
//     *
//     * @param username 用户名
//     * @param password 密码
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(String username, String password) {
//        // 从SecurityUtils里边创建一个 subject
//        Subject subject = SecurityUtils.getSubject();
//        // 在认证提交前准备 token（令牌）
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        // 执行认证登陆
//        subject.login(token);
//        //根据权限，指定返回数据
//       return "success";
//    }
//}
