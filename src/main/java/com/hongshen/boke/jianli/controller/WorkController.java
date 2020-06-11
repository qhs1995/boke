package com.hongshen.boke.jianli.controller;

import com.hongshen.boke.dao.jianli.object.WorkDO;
import com.hongshen.boke.jianli.service.WorkService;
import com.hongshen.boke.response.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/23 9:42
 * @Desc: 工作经历
 */
@Controller
@RequestMapping("/jianli/work")
public class WorkController {
    private static final Logger logger = LoggerFactory.getLogger(WorkController.class);

    @Autowired
    private WorkService workService;

    @RequestMapping("list.html")
    @ResponseBody
    public ResultResponse<List<WorkDO>> queryList(Integer page,Integer limit){
        List<WorkDO> list = workService.queryList(page, limit);
        ResultResponse<List<WorkDO>> response = ResultResponse.create();
        response.setCount(list.size());
        response.setData(list);
        return response;
    }

    @RequestMapping("query.html")
    public String query(Model model,Integer id){
        WorkDO aDo = workService.query(id);
        model.addAttribute("result",aDo);
        return "jianli/back/work-query";
    }

    @RequestMapping("edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody WorkDO ado){
       return workService.edit(ado);
    }

    @RequestMapping("del.html")
    @ResponseBody
    public ResultResponse<String> del(Integer id){
       return workService.del(id);
    }

    @RequestMapping("index.html")
    public String index(){
        return "jianli/back/work-list";
    }

    @RequestMapping("work-edit.html")
    public String info(){
        return "jianli/back/work-edit";
    }

}
