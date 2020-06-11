package com.hongshen.boke.service.impl;

import com.github.pagehelper.PageHelper;
import com.hongshen.boke.dao.mapper.CommentsMapper;
import com.hongshen.boke.dao.mapper.TouristMapper;
import com.hongshen.boke.dao.object.CommentsDO;
import com.hongshen.boke.dao.object.TouristDO;
import com.hongshen.boke.dao.object.TouristExample;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.comments.CommentsResponse;
import com.hongshen.boke.service.TouristService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/9 14:29
 * @Desc:
 */
@Service
public class TouristServiceImpl implements TouristService {
    private static final Logger logger = LoggerFactory.getLogger(TouristServiceImpl.class);

    @Autowired
    private TouristMapper touristMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public ResultResponse<String> edit(TouristDO touristDO) {
        Date date = new Date();
        touristDO.setCreatTime(date);
        if (touristDO.getId()!=null){
            try {
                touristMapper.updateByPrimaryKeySelective(touristDO);
                return ResultResponse.successResponse("修改成功",null);
            } catch (Exception e) {
                logger.error("游客信息修改失败  id={} 错误信息=",touristDO.getId(),e);
                return ResultResponse.failResponse(1,"修改失败,系统异常",null);
            }
        }
        try {
            touristMapper.insertSelective(touristDO);
            return ResultResponse.successResponse("创建成功",null);
        } catch (Exception e) {
            logger.error("游客创建失败   错误信息=",e);
            return ResultResponse.failResponse(1,"创建失败,系统异常",null);
        }

    }

    @Override
    public ResultResponse<String> delete(Integer id) {
        try {
            touristMapper.deleteByPrimaryKey(id);
            return ResultResponse.successResponse("删除成功",null);
        } catch (Exception e) {
            logger.error("删除游客失败   id={}  错误信息=",id,e);
            return ResultResponse.failResponse(1,"删除失败,系统异常",null);
        }

    }

    @Override
    public ResultResponse<TouristDO> query(Integer id) {
        try {
            TouristDO touristDO = touristMapper.selectByPrimaryKey(id);
            if (touristDO ==null){
                return ResultResponse.successResponse("查询成功，无此人数据",null);
            }
            return ResultResponse.successResponse("查询成功",touristDO);
        } catch (Exception e) {
            logger.error("查询游客信息失败 id={} 错误信息=",id,e);
            return ResultResponse.failResponse(1,"查询失败,系统异常",null);
        }

    }

    @Override
    public ResultResponse<List<TouristDO>> list(Integer page,Integer limit,String username) {
        try {
            PageHelper.startPage(page,limit);
            TouristExample example = new TouristExample();
            if (username!=null && username!=""){
                example.createCriteria().andUsernameLike(username);
            }
            List<TouristDO> touristDOList = touristMapper.selectByExample(example);
            if (touristDOList==null || touristDOList.size()<=0){
                return ResultResponse.successResponse("查询成功,暂无数据",null);
            }
            ResultResponse<List<TouristDO>> response = ResultResponse.create();
            response.setData(touristDOList);
            response.setCount(touristDOList.size());
            response.setMsg("查询成功");
            response.setCode(0);
            return response;
        } catch (Exception e) {
            logger.error("查询游客列表失败 错误信息=",e);
            return ResultResponse.failResponse(1,"查询失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<TouristDO> login(String username, String password) {
        TouristExample example = new TouristExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<TouristDO> touristDOList = touristMapper.selectByExample(example);
        if (touristDOList==null ||touristDOList.size()<=0){
            return ResultResponse.failResponse(1,"账号或密码错误，请重试！",null);
        }
        TouristDO aDo = touristDOList.get(0);
        //redisTemplate.opsForValue().set(aDo.getUsername(),aDo);
        //TimeUnit.MILLISECONDS 表示时间单位为千分之一秒
        //redisTemplate.expire(aDo.getUsername(),1000*60*30,TimeUnit.MILLISECONDS);
        return ResultResponse.successResponse("登录成功",aDo);
    }

    @Override
    public ResultResponse<CommentsResponse> creatMessage(TouristDO touristDO, String articleId, String leaveComments) {
        try {
            Date date = new Date();
            CommentsDO commentsDO = new CommentsDO();
            commentsDO.setCreatTime(date);
            commentsDO.setArticleId(Integer.parseInt(articleId));
            commentsDO.setTouristId(touristDO.getId());
            commentsDO.setLeaveComments(leaveComments);
            commentsMapper.insert(commentsDO);
            CommentsResponse commentsResponse = new CommentsResponse();
            commentsResponse.setCreatTime(date);
            commentsResponse.setNickname(touristDO.getNickname());
            commentsResponse.setLeaveComments(leaveComments);
            return ResultResponse.successResponse("留言成功",commentsResponse);
        } catch (Exception e) {
            logger.error("留言失败 错误信息=",e);
            return ResultResponse.failResponse(1,"留言失败",null);
        }
    }
}
