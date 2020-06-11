package com.hongshen.boke.jianli.controller;

import com.hongshen.boke.dao.jianli.object.ProjectDO;
import com.hongshen.boke.jianli.service.ProjectService;
import com.hongshen.boke.response.ResultResponse;
import org.apache.commons.io.FileUtils;
import org.apache.regexp.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/23 9:42
 * @Desc: 项目介绍
 */
@Controller
@RequestMapping("/jianli/project")
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);


    @Autowired
    private ProjectService projectService;

    @RequestMapping("list.html")
    @ResponseBody
    public ResultResponse<List<ProjectDO>> queryList(Integer page, Integer limit){
        List<ProjectDO> list = projectService.queryList(page, limit);
        ResultResponse<List<ProjectDO>> response = ResultResponse.create();
        response.setData(list);
        response.setCount(list.size());
        return response;
    }

    @RequestMapping("query.html")
    public String query(Model model,Integer id){
        ProjectDO aDo = projectService.query(id);
        model.addAttribute("result",aDo);
        return "jianli/back/project-query";
    }

    @RequestMapping("edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody ProjectDO ado){
       return projectService.edit(ado);
    }

    @RequestMapping("del.html")
    @ResponseBody
    public ResultResponse<String> del(Integer id){
      return projectService.del(id);
    }


    @RequestMapping("index.html")
    public String index(){
        return "jianli/back/project-list";
    }

    @RequestMapping("project-edit.html")
    public String info(){
        return "jianli/back/project-edit";
    }



}
