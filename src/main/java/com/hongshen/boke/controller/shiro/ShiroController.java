package com.hongshen.boke.controller.shiro;

import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.article.ArticleListResponse;
import com.hongshen.boke.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/7/3 17:27
 * @Desc: shiro测试controller
 */
@Controller
@RequestMapping("shiro")
public class ShiroController {
    private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);


    @Autowired
    private ArticleService articleService;

    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestParam("username")String username,@RequestParam("password")String password){
        Subject subject = SecurityUtils.getSubject();
        //判断是否已经登录
        if (!subject.isAuthenticated()){
            //未登录
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
           // UsernamePasswordAndOtherToken token = new UsernamePasswordAndOtherToken(username, password, "123456");
            //记住我
            token.setRememberMe(true);
            try {
                subject.login(token);
            } catch (UnknownAccountException e) {
                //没有找到指定的登录账户
                System.out.println("找不到该账号");
                return "not_success";

            }catch (IncorrectCredentialsException e) {
                //登录账户存在，密码错误
                System.out.println("密码错误");
                return "not_success";
            }catch (LockedAccountException e) {
                //用户被锁定
                System.out.println("用户被锁定");
                return "not_success";
            }catch (AuthenticationException e) {
                //所有认证错误的父类异常
                System.out.println("我是父类");
                return "not_success";
            }

        }

        return "success";

    }

    @RequestMapping("a")
    @ResponseBody
    public ResultResponse<List<ArticleListResponse>> logins(){
        System.out.println("我进来了");
        ResultResponse<List<ArticleListResponse>> response = articleService.list(1,10);
        return response;
    }

}
