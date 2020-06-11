package com.hongshen.boke.jianli.service.impl;

import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.jianli.mapper.ProjectMapper;
import com.hongshen.boke.dao.jianli.object.ProjectDO;
import com.hongshen.boke.dao.jianli.object.ProjectExample;
import com.hongshen.boke.jianli.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);


    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectDO> queryList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        ProjectExample example = new ProjectExample();
        return projectMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public ProjectDO query(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultResponse<String> edit(ProjectDO ado) {
        if (ado.getId() == null){
            //新增
            projectMapper.insertSelective(ado);
        }else {
            //修改
            projectMapper.updateByPrimaryKeySelective(ado);
        }
        return ResultResponse.successResponse("成功",null);
    }

    @Override
    public ResultResponse<String> del(Integer id) {
        projectMapper.deleteByPrimaryKey(id);
        return ResultResponse.successResponse("成功",null);
    }
}
