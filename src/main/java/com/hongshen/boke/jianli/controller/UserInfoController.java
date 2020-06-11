package com.hongshen.boke.jianli.controller;

import com.hongshen.boke.dao.jianli.object.UserinfoDO;
import com.hongshen.boke.jianli.service.UserInfoService;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/23 9:42
 * @Desc: 基本资料
 */
@Controller
@RequestMapping("/jianli/userinfo/")
public class UserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);


    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("list.html")
    @ResponseBody
    public ResultResponse<List<UserinfoDO>> queryList(Integer page,Integer limit){
        List<UserinfoDO> list = userInfoService.queryList(page, limit);
        ResultResponse<List<UserinfoDO>> response = ResultResponse.create();
        response.setCount(list.size());
        response.setData(list);
        return response;
    }

    @RequestMapping("query.html")
    public String query(Model model,Integer id){
        UserinfoDO aDo = userInfoService.query(id);
        model.addAttribute("result",aDo);
        return "jianli/back/userinfo-query";
    }

    @RequestMapping("edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody UserinfoDO ado){
        return userInfoService.edit(ado);
    }

    @RequestMapping("del.html")
    @ResponseBody
    public ResultResponse<String> del(Integer id){
       return userInfoService.del(id);
    }


    @RequestMapping("index.html")
    public String index(){
        return "jianli/back/userinfo-list";
    }

    @RequestMapping("userinfo-edit.html")
    public String info(){
        return "jianli/back/userinfo-edit";
    }




    @RequestMapping("jianli-upload.html")
    public String upload(){
        return "jianli/back/jianli-upload";
    }
    /**
     * 简历上传
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload.html")
    @ResponseBody
    public ResultResponse<String>  uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(),"static/upload/");
        if(!upload.exists()) {
            upload.mkdirs();
        }
        File copeFile = new File(path.getAbsolutePath(),"static/upload/haha.doc");
        FileUtils.copyInputStreamToFile(file.getInputStream(), copeFile);
        return ResultResponse.successResponse("添加成功！",null);
    }


}
