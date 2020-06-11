package com.hongshen.boke.jianli.service;

import com.hongshen.boke.dao.jianli.object.AppraisalDO;
import com.hongshen.boke.response.ResultResponse;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/23 9:43
 * @Desc:
 */
public interface AppraisalService {

    /**
     * 查询列表
     * @param page
     * @param limit
     * @return
     */
    List<AppraisalDO> queryList(Integer page, Integer limit);


    /**
     * 查询
     * @param id
     * @return
     */
    AppraisalDO query(Integer id);


    /**
     * 新增或修改
     * @param ado
     * @return
     */
    ResultResponse<String> edit(AppraisalDO ado);

    /**
     * 删除
     * @param id
     * @return
     */
    ResultResponse<String> del(Integer id);


}
