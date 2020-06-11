package com.hongshen.boke.controller;

import com.hongshen.boke.dao.mapper.TbfileMapper;
import com.hongshen.boke.dao.object.TbfileDO;
import com.hongshen.boke.dao.object.UserDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.service.UserService;
import com.hongshen.boke.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/13 15:10
 * @Desc: 管理员
 */
@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/manager/user/list.html")
    public String user(){
        return "manager/user-list";
    }
    @RequestMapping("/manager/user/user-edit.html")
    public String userEdit(){
        return "manager/user-edit";
    }

    @RequestMapping("/manager/user/queryList.html")
    @ResponseBody
    public ResultResponse<List<UserDO>> list(Integer page,Integer limit){
        ResultResponse<List<UserDO>> response = userService.list(page, limit);
        return response;
    }


    @RequestMapping("/manager/user/query.html")
    public String query(Model model,Integer id){
        ResultResponse<UserDO> response = userService.query(id);
        model.addAttribute("user",response.getData());
        return "manager/user-query";
    }

    @RequestMapping("/manager/user/edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody UserDO userDO){
        ResultResponse<String> response = userService.edit(userDO);
        return response;
    }

    @RequestMapping("/manager/user/delete.html")
    @ResponseBody
    public ResultResponse<String> delete(Integer id){
        ResultResponse<String> response = userService.delete(id);
        return response;
    }

    /**
     * 图片上传接口
     * @param file 图片
     * @param status  status==1 标识是从富文本过来的  为空则为普通上传
     * @return  图片保存在阿里云上的路径
     */
    @RequestMapping(value = "/headImgUpload.html")
    @ResponseBody
    public ResultResponse  headImgUpload(Model model, @RequestParam("file") MultipartFile file,Integer status) {
        try {
            String url = userService.updateHead(file);
//            String url ="http://hongshenboke.oss-cn-hangzhou.aliyuncs.com/data/1542274558777.jpg";
            if (status!=null){
                Map<String, String> map = new HashMap<>(2);
                map.put("src",url);
                map.put("title",file.getName());
                ResultResponse<Map<String,String>> response = ResultResponse.create();
                response.setCode(0);
                response.setData(map);
                return response;
            }else {
                model.addAttribute("fileUrl",url);
            }
            return ResultResponse.successResponse("上传成功",url);
        } catch (Exception e) {
           logger.error("图片上传失败  图片名={}  错误原因=",file.getName(),e);
        }
        return ResultResponse.failResponse(1,"上传失败,系统异常",null);
    }



}
