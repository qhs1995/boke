package com.hongshen.boke.service.impl;
import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.mapper.UserMapper;
import com.hongshen.boke.dao.object.UserDO;
import com.hongshen.boke.dao.object.UserExample;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.service.UserService;
import com.hongshen.boke.utils.OSSClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author:qianhongshen
 * Date:2018/10/12
 * Time:15:10
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;


    @Override
    public ResultResponse<UserDO> login(UserDO userDO) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userDO.getUsername());
        criteria.andPasswordEqualTo(userDO.getPassword());
        try {
            List<UserDO> userDOS = userMapper.selectByExample(userExample);
            if (userDOS.size()>0 && userDOS!=null){
                return ResultResponse.successResponse("登录成功",userDOS.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.failResponse(1,"登录失败,系统异常",null);
        }
        return ResultResponse.failResponse(1,"登录失败，账号或密码错误",null);
    }

    @Override
    public ResultResponse<String> out() {
        
        return null;
    }

    @Override
    public ResultResponse<List<UserDO>> list(Integer page,Integer limit) {
        try {
            PageHelper.startPage(page,limit);
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            List<UserDO> userDOList = userMapper.selectByExample(example);
            if (userDOList==null ||userDOList.size()<=0){
                return ResultResponse.failResponse(1,"查询为空",null);
            }
            ResultResponse<List<UserDO>> response = ResultResponse.create();
            response.setData(userDOList);
            response.setCount(userDOList.size());
            response.setMsg("查询成功");
            response.setCode(0);
            return response;
        } catch (Exception e) {
            logger.error("查询管理员列表失败 错误信息=",e);
            return ResultResponse.failResponse(1,"查询失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<UserDO> query(Integer id) {
        try {
            UserDO userDO = userMapper.selectByPrimaryKey(id);
            if (userDO==null){
                return ResultResponse.failResponse(1,"查询为空",null);
            }
            return ResultResponse.successResponse("查询成功",userDO);
        } catch (Exception e) {
            logger.error("查询失败 id={} 错误原因=",id,e);
            return ResultResponse.failResponse(1,"查询失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<String> edit(UserDO userDO) {
        if (userDO.getId()==null){
            try {
                userMapper.insertSelective(userDO);
                return ResultResponse.successResponse("添加成功",null);
            } catch (Exception e) {
                logger.error("管理员添加失败 错误信息=",e);
                return ResultResponse.failResponse(1,"添加失败",null);
            }
        }
        try {
            userMapper.updateByPrimaryKeySelective(userDO);
            return ResultResponse.successResponse("修改成功",null);
        } catch (Exception e) {
            logger.error("修改失败 错误原因=",e);
            return ResultResponse.failResponse(1,"修改失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<String> delete(Integer id) {
        try {
            userMapper.deleteByPrimaryKey(id);
            return ResultResponse.successResponse("删除成功",null);
        } catch (Exception e) {
            logger.error("删除管理员失败 错误原因=",e);
            return ResultResponse.failResponse(1,"删除失败，系统异常",null);
        }
    }

    @Override
    public UserDO queryUser() {
        try {
            UserExample example = new UserExample();
            List<UserDO> userDOList = userMapper.selectByExample(example);
            if (userDOList==null ||userDOList.size()<=0){
                return null;
            }
            return userDOList.get(0);
        } catch (Exception e) {
            logger.error("前台首页展示查询用户失败  错误原因=",e);
            return null;
        }
    }

    @Override
    public String updateHead(MultipartFile file) {
        if (file == null || file.getSize() <= 0) {
          logger.error("file 为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        return split[0];
    }


}
