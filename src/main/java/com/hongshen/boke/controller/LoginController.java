package com.hongshen.boke.controller;

import com.hongshen.boke.dao.object.UserDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author:qianhongshen
 * Date:2018/11/7
 * Time:11:19
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/manager/logins.html")
    @ResponseBody
    public ResultResponse<String> logins(@RequestBody UserDO userDO, HttpServletRequest request){
        ResultResponse<UserDO> response = userService.login(userDO);
        HttpSession session = request.getSession();
        if (response.isSuccess()){
            session.setAttribute("user",response.getData());
            return ResultResponse.successResponse("登录成功",null);
        }
        return ResultResponse.failResponse(1,response.getMsg(),null);
    }


    @RequestMapping("/manager/out.html")
    public String out( HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "manager/login";
    }

    @RequestMapping("/manager/userDetails.html")
    public String userDetails(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDO user =(UserDO) session.getAttribute("user");
        model.addAttribute("user",user);
        return "manager/user-details";
    }

}
