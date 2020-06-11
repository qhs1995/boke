package com.hongshen.boke.controller;

import com.hongshen.boke.dao.object.UserDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author:qianhongshen
 * Date:2018/11/7
 * Time:11:19
 */
@Controller
public class IndexController {

    /**
     * 跳转到博客后台登录界面
     * @return
     */
    @RequestMapping("/manager/login.html")
    public String managerIndex(){
        return "manager/login";
    }

    /**
     * 跳转到博客后台登陆后的首页
     * @return
     */
    @RequestMapping("/manager/index.html")
    public String main(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDO user = (UserDO)session.getAttribute("user");
        if (user==null){
            return "manager/login";
        }
        model.addAttribute("user",user);
        return "manager/index";
    }
    @RequestMapping("/manager/welcome.html")
    public String welcome(){
        return "manager/welcome";
    }




}
