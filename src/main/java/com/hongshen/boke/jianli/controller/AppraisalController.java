package com.hongshen.boke.jianli.controller;

import com.hongshen.boke.dao.jianli.object.AppraisalDO;
import com.hongshen.boke.jianli.service.AppraisalService;
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
 * @Desc: 自我评价
 */
@Controller
@RequestMapping("/jianli/appraisal")
public class AppraisalController {
    private static final Logger logger = LoggerFactory.getLogger(AppraisalController.class);

    @Autowired
    private AppraisalService appraisalService;

    @RequestMapping("list.html")
    @ResponseBody
    public ResultResponse<List<AppraisalDO>> queryList(Integer page,Integer limit){
        List<AppraisalDO> list = appraisalService.queryList(page, limit);
        ResultResponse<List<AppraisalDO>> response = ResultResponse.create();
        response.setCount(list.size());
        response.setData(list);
        return response;
    }

    @RequestMapping("query.html")
    public String query(Model model,Integer id){
        AppraisalDO aDo = appraisalService.query(id);
        model.addAttribute("result",aDo);
        return "jianli/back/appraisal-query";
    }

    @RequestMapping("edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody AppraisalDO ado){
        return appraisalService.edit(ado);
    }

    @RequestMapping("del.html")
    @ResponseBody
    public ResultResponse<String> del(Integer id){
        return appraisalService.del(id);
    }


    @RequestMapping("index.html")
    public String index(){
        return "jianli/back/appraisal-list";
    }

    @RequestMapping("appraisal-edit.html")
    public String info(){
        return "jianli/back/appraisal-edit";
    }

}
