package com.hongshen.boke.dao.mapper.mymapper;

import com.hongshen.boke.dao.object.ArticleDO;
import com.hongshen.boke.response.article.ArticleListResponse;
import com.hongshen.boke.response.article.ArticleQueryResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2018/11/07
 */
@Mapper
public interface MyArticleMapper {

    List<ArticleListResponse> list();

    ArticleQueryResponse queryById(@Param("id") Integer id);

    List<ArticleDO> queryArticleForParentColumn(@Param("id") Integer id);

    List<ArticleDO> queryByTitle(@Param("articleTitle")String articleTitle);

}