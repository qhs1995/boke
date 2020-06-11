package com.hongshen.boke.jianli.service.impl;

import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.jianli.mapper.UserinfoMapper;
import com.hongshen.boke.dao.jianli.object.UserinfoDO;
import com.hongshen.boke.dao.jianli.object.UserinfoExample;
import com.hongshen.boke.jianli.service.UserInfoService;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.utils.StringUtils;
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
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public List<UserinfoDO> queryList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        UserinfoExample example = new UserinfoExample();
        return userinfoMapper.selectByExample(example);
    }

    @Override
    public UserinfoDO query(Integer id) {
      return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultResponse<String> edit(UserinfoDO ado) {
        if (ado.getId() == null){
            //新增
            userinfoMapper.insertSelective(ado);
        }else{
            userinfoMapper.updateByPrimaryKeySelective(ado);
        }
        return ResultResponse.successResponse("操作成功",null);
    }

    @Override
    public ResultResponse<String> del(Integer id) {
        userinfoMapper.deleteByPrimaryKey(id);
        return ResultResponse.successResponse("删除成功",null);
    }
}
