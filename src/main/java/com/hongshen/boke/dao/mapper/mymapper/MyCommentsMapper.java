package com.hongshen.boke.dao.mapper.mymapper;

import com.hongshen.boke.response.comments.CommentsResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/12/4 15:27
 * @Desc:
 */
@Mapper
public interface MyCommentsMapper {

    List<CommentsResponse> findByarticleId(@Param("articleId") Integer articleId);
}
