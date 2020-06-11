package com.hongshen.boke.controller;

import com.hongshen.boke.dao.object.ColumnDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.service.ColumnService;
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
 * @Date:2018/11/12 13:51
 * @Desc: 博客后台栏目
 */
@Controller
public class ColumnController {
    private static final Logger logger = LoggerFactory.getLogger(ColumnController.class);

    @Autowired
    private ColumnService columnService;

    @RequestMapping("/manager/column/list.html")
    public String column(){
        return "manager/column-list.html";
    }
    @RequestMapping("/manager/column/column-edit.html")
    public String columnEdit(){
        return "manager/column-edit.html";
    }

    @RequestMapping("/manager/column/queryList.html")
    @ResponseBody
    public ResultResponse<List<ColumnDO>> list(Integer page, Integer limit){
        ResultResponse<List<ColumnDO>> response = columnService.list(page, limit);
        return response;
    }

    @RequestMapping("/manager/column/query.html")
    public String query(Model model,Integer id){
        ResultResponse<ColumnDO> response = columnService.query(id);
        model.addAttribute("column",response.getData());
        return "manager/column-query.html";
    }

    @RequestMapping("/manager/column/edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody ColumnDO columnDO){
        ResultResponse<String> response = columnService.edit(columnDO);
        return response;
    }

    @RequestMapping("/manager/column/delete.html")
    @ResponseBody
    public ResultResponse<String> delete(Integer id){
        ResultResponse<String> response = columnService.delete(id);
        return response;
    }

    /**
     * 查询父栏目
     * @param id
     * @return
     */
    @RequestMapping("/manager/column/queryParentColumn.html")
    @ResponseBody
    public ResultResponse<List<ColumnDO>> queryParentColumn(Integer id){
        ResultResponse<List<ColumnDO>> response = columnService.queryParentColumn(id);
        return response;
    }

    /**
     * 根据父id查询下面的子栏目
     * @param pId 父栏目id
     * @return
     */
    @RequestMapping("/manager/column/queryChildColumn.html")
    @ResponseBody
    public ResultResponse<List<ColumnDO>> queryChildColumn(Integer pId){
        ResultResponse<List<ColumnDO>> response = columnService.queryChildColumn(pId);
        return response;
    }

}
