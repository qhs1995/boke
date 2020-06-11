package com.hongshen.boke.service;

import com.hongshen.boke.dao.object.CommentsDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.comments.CommentsResponse;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/12/4 15:03
 * @Desc: 留言
 */
public interface CommentsService {

    ResultResponse<List<CommentsResponse>> findByarticleId(Integer articleId);
}
