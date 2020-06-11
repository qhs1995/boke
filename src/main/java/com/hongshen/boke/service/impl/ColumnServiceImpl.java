package com.hongshen.boke.service.impl;

import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.mapper.ColumnMapper;
import com.hongshen.boke.dao.object.ColumnDO;
import com.hongshen.boke.dao.object.ColumnExample;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.service.ColumnService;
import com.hongshen.boke.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/12 13:52
 * @Desc:
 */
@Service
public class ColumnServiceImpl implements ColumnService {
    private static final Logger logger = LoggerFactory.getLogger(ColumnServiceImpl.class);

    @Autowired
    private ColumnMapper columnMapper;

    @Override
    public ResultResponse<List<ColumnDO>> list(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        ColumnExample example = new ColumnExample();
        try {
            List<ColumnDO> columnDOList = columnMapper.selectByExample(example);
            if (columnDOList==null || columnDOList.size()<=0){
                return ResultResponse.failResponse(1,"暂无数据",null);
            }
            return ResultResponse.successResponse("查询成功",columnDOList);
        } catch (Exception e) {
           logger.error("查询栏目列表失败 错误信息=",e);
           return ResultResponse.failResponse(1,"查询失败，系统异常",null);
        }

    }

    @Override
    public ResultResponse<ColumnDO> query(Integer id) {
        try {
            ColumnDO columnDO = columnMapper.selectByPrimaryKey(id);
            if (columnDO==null){
                return ResultResponse.failResponse(1,"查询失败",null);
            }
            return ResultResponse.successResponse("查询成功",columnDO);
        } catch (Exception e) {
           logger.error("查询栏目失败 错误信息=",e);
           return ResultResponse.failResponse(1,"查询失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<String> edit(ColumnDO columnDO) {
        if (columnDO.getParentId()!=null){
            ColumnExample example = new ColumnExample();
            example.createCriteria().andIdEqualTo(columnDO.getParentId());
            List<ColumnDO> columnDOS = columnMapper.selectByExample(example);
            if (columnDOS!=null && columnDOS.size()>0){
                columnDO.setParentName(columnDOS.get(0).getName());
            }
        }
        if (columnDO.getId()==null){
            try {
                columnMapper.insertSelective(columnDO);
                return ResultResponse.successResponse("添加成功",null);
            } catch (Exception e) {
                logger.error("添加栏目失败  错误信息=",e);
              return ResultResponse.failResponse(1,"添加失败",null);
            }
        }
        try {
            columnMapper.updateByPrimaryKey(columnDO);
            return ResultResponse.successResponse("修改成功",null);
        } catch (Exception e) {
            logger.error("修改栏目失败 错误信息=",e);
            return ResultResponse.failResponse(1,"修改栏目失败,系统异常",null);
        }

    }

    @Override
    public ResultResponse<String> delete(Integer id) {
        try {
            columnMapper.deleteByPrimaryKey(id);
            return ResultResponse.successResponse("删除成功",null);
        } catch (Exception e) {
            logger.error("删除栏目失败 错误信息=",e);
            return ResultResponse.failResponse(1,"删除栏目失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<List<ColumnDO>> queryParentColumn(Integer id) {
        try {
            ColumnExample example = new ColumnExample();
            ColumnExample.Criteria criteria = example.createCriteria();
            if (id!=null){
                ColumnDO columnDO = columnMapper.selectByPrimaryKey(id);
                if (columnDO.getParentId()==null){
                    criteria.andIdNotEqualTo(columnDO.getId());
                }
            }
            criteria.andParentIdIsNull();
            List<ColumnDO> columnDOList = columnMapper.selectByExample(example);
            if (columnDOList==null || columnDOList.size()<=0){
                return ResultResponse.successResponse("查询为空",null);
            }
            return ResultResponse.successResponse("查询成功",columnDOList);
        } catch (Exception e) {
            logger.error("查询失败  错误信息=",e);
            return ResultResponse.failResponse(1,"查询失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<List<ColumnDO>> queryChildColumn(Integer pId) {
        ColumnExample example = new ColumnExample();
        ColumnExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pId);
        try {
            List<ColumnDO> columnDOList = columnMapper.selectByExample(example);
            return ResultResponse.successResponse("查询成功",columnDOList);
        } catch (Exception e) {
            logger.error("查询子栏目失败 错误信息=",e);
            return ResultResponse.failResponse(1,"查询失败",null);
        }
    }

    @Override
    public ResultResponse<List<ColumnDO>> queryAllChildColumn() {
        try {
            ColumnExample example = new ColumnExample();
            ColumnExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdIsNotNull();
            List<ColumnDO> columnDOList = columnMapper.selectByExample(example);
            return ResultResponse.successResponse("查询成功",columnDOList);
        } catch (Exception e) {
            logger.error("查询所有子栏目失败 错误原因=",e);
            return ResultResponse.failResponse(1,"查询失败",null);
        }
    }
}
