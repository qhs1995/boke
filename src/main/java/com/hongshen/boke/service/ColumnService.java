package com.hongshen.boke.service;

import com.hongshen.boke.dao.object.ColumnDO;
import com.hongshen.boke.response.ResultResponse;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/12 13:51
 * @Desc:
 */
public interface ColumnService {

    ResultResponse<List<ColumnDO>> list(Integer page, Integer limit);

    ResultResponse<ColumnDO> query(Integer id);

    ResultResponse<String> edit( ColumnDO columnDO);

    ResultResponse<String> delete(Integer id);

    ResultResponse<List<ColumnDO>> queryParentColumn(Integer id);

    ResultResponse<List<ColumnDO>> queryChildColumn(Integer pId);

    ResultResponse<List<ColumnDO>> queryAllChildColumn();
}
