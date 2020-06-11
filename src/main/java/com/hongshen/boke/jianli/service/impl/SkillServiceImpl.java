package com.hongshen.boke.jianli.service.impl;

import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.jianli.mapper.SkillMapper;
import com.hongshen.boke.dao.jianli.object.SkillDO;
import com.hongshen.boke.dao.jianli.object.SkillExample;
import com.hongshen.boke.jianli.service.SkillService;
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
 * @Date:2019/9/23 16:23
 * @Desc:
 */
@Service
public class SkillServiceImpl implements SkillService {
    private static final Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);

    @Autowired
    private SkillMapper skillMapper;

    @Override
    public List<SkillDO> queryList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        SkillExample example = new SkillExample();
        return skillMapper.selectByExample(example);
    }

    @Override
    public SkillDO query(Integer id) {
        return skillMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultResponse<String> edit(SkillDO ado) {
        if (ado.getId() == null){
            //新增
            skillMapper.insertSelective(ado);
        }else{
            skillMapper.updateByPrimaryKeySelective(ado);
        }
        return ResultResponse.successResponse("操作成功",null);
    }

    @Override
    public ResultResponse<String> del(Integer id) {
        skillMapper.deleteByPrimaryKey(id);
        return ResultResponse.successResponse("删除成功",null);
    }
}
