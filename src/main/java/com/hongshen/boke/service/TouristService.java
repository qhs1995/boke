package com.hongshen.boke.service;

import com.hongshen.boke.dao.object.TouristDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.comments.CommentsResponse;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/9 14:29
 * @Desc: 游客
 */
public interface TouristService {

    ResultResponse<String> edit(TouristDO touristDO);

    ResultResponse<String> delete(Integer id);

    ResultResponse<TouristDO> query(Integer id);

    ResultResponse<List<TouristDO>> list(Integer page,Integer limit,String username);

    ResultResponse<TouristDO> login(String username ,String password);

    /**
     * 博客前台创建留言
     * @param touristDO 游客实体
     * @param articleId 文章id
     * @param leaveComments 留言信息
     */
    ResultResponse<CommentsResponse> creatMessage(TouristDO touristDO, String articleId, String leaveComments);
}
