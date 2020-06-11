package com.hongshen.boke.jianli.service.impl;

import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.jianli.mapper.WorkMapper;
import com.hongshen.boke.dao.jianli.object.WorkDO;
import com.hongshen.boke.dao.jianli.object.WorkExample;
import com.hongshen.boke.jianli.service.WorkService;
import com.hongshen.boke.response.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/23 9:44
 * @Desc:
 */
@Service
public class WorkServiceImpl implements WorkService {
    private static final Logger logger = LoggerFactory.getLogger(WorkServiceImpl.class);

    @Autowired
    private WorkMapper workMapper;

    @Override
    public List<WorkDO> queryList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        WorkExample example = new WorkExample();
        return workMapper.selectByExample(example);
    }

    @Override
    public WorkDO query(Integer id) {
        return workMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultResponse<String> edit(WorkDO ado) {
        if (ado.getId() == null){
            //新增
            workMapper.insertSelective(ado);
        }else {
            //修改
            workMapper.updateByPrimaryKeySelective(ado);
        }
        return ResultResponse.successResponse("操作成功",null);
    }

    @Override
    public ResultResponse<String> del(Integer id) {
        workMapper.deleteByPrimaryKey(id);
        return ResultResponse.successResponse("删除成功",null);
    }
}
