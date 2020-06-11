package com.hongshen.boke.jianli.service.impl;

import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.jianli.mapper.AppraisalMapper;
import com.hongshen.boke.dao.jianli.object.AppraisalDO;
import com.hongshen.boke.dao.jianli.object.AppraisalExample;
import com.hongshen.boke.jianli.service.AppraisalService;
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
public class AppraisalServiceImpl implements AppraisalService {
    private static final Logger logger = LoggerFactory.getLogger(AppraisalServiceImpl.class);

    @Autowired
    private AppraisalMapper appraisalMapper;

    @Override
    public List<AppraisalDO> queryList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        AppraisalExample example = new AppraisalExample();
        return appraisalMapper.selectByExample(example);
    }

    @Override
    public AppraisalDO query(Integer id) {
        return appraisalMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultResponse<String> edit(AppraisalDO ado) {
        if (ado.getId() == null){
            //新增
            appraisalMapper.insertSelective(ado);
        }else {
            //修改
            appraisalMapper.updateByPrimaryKeySelective(ado);
        }
        return ResultResponse.successResponse("操作成功",null);
    }

    @Override
    public ResultResponse<String> del(Integer id) {
        appraisalMapper.deleteByPrimaryKey(id);
        return ResultResponse.successResponse("删除成功",null);
    }
}
