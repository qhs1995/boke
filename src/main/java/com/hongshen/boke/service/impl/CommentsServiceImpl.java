package com.hongshen.boke.service.impl;

import com.hongshen.boke.dao.mapper.CommentsMapper;
import com.hongshen.boke.dao.mapper.mymapper.MyCommentsMapper;
import com.hongshen.boke.dao.object.CommentsDO;
import com.hongshen.boke.dao.object.CommentsExample;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.comments.CommentsResponse;
import com.hongshen.boke.service.CommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/12/4 15:03
 * @Desc:
 */
@Service
public class CommentsServiceImpl implements CommentsService {
    private static final Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);


    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private MyCommentsMapper myCommentsMapper;

    @Override
    public ResultResponse<List<CommentsResponse>> findByarticleId(Integer articleId) {
        try {
            List<CommentsResponse> commentsDOList =myCommentsMapper.findByarticleId(articleId);
            return ResultResponse.successResponse("查询成功",commentsDOList);
        } catch (Exception e) {
            logger.error("查询文章下留言失败 文章id={} 错误信息=",articleId,e);
            return ResultResponse.failResponse(1,"查询失败",null);
        }
    }
}
