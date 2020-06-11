package com.hongshen.boke.jianli.controller;

import com.hongshen.boke.dao.jianli.object.AppraisalDO;
import com.hongshen.boke.dao.jianli.object.SkillDO;
import com.hongshen.boke.jianli.service.SkillService;
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
 * @Date:2019/9/23 16:21
 * @Desc: 专业技能
 */
@Controller
@RequestMapping("/jianli/skill")
public class SkillController {
    private static final Logger logger = LoggerFactory.getLogger(SkillController.class);

    @Autowired
    private SkillService skillService;

    @RequestMapping("list.html")
    @ResponseBody
    public ResultResponse<List<SkillDO>> queryList(Integer page, Integer limit){
        List<SkillDO> list = skillService.queryList(page, limit);
        ResultResponse<List<SkillDO>> response = ResultResponse.create();
        response.setCount(list.size());
        response.setData(list);
        return response;
    }

    @RequestMapping("query.html")
    public String query(Model model, Integer id){
        SkillDO aDo = skillService.query(id);
        model.addAttribute("result",aDo);
        return "jianli/back/skill-query";
    }

    @RequestMapping("edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody SkillDO ado){
        return skillService.edit(ado);
    }

    @RequestMapping("del.html")
    @ResponseBody
    public ResultResponse<String> del(Integer id){
        return skillService.del(id);
    }


    @RequestMapping("index.html")
    public String index(){
        return "jianli/back/skill-list";
    }

    @RequestMapping("skill-edit.html")
    public String info(){
        return "jianli/back/skill-edit";
    }
}
