package com.hongshen.boke.service;

import com.hongshen.boke.dao.object.ArticleDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.article.ArticleListResponse;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/7 17:51
 * @Desc: 博客文章
 */
public interface ArticleService {

    ResultResponse<List<ArticleListResponse>> list(Integer page,Integer limit);


    /**
     * 添加或修改文章
     * @param articleDO
     * @return 操作返回状态
     */
    ResultResponse<String> edit(ArticleDO articleDO);


    ResultResponse<ArticleDO> query(Integer id);

    ResultResponse<String> delete(Integer id);

    /**
     * 查看子栏目下的文章
     * @param id
     * @return
     */
    List<ArticleDO> queryArticleForChildColumn(Integer id);
    /**
     * 查看父栏目下的所有文章
     * @param id
     * @return
     */
    List<ArticleDO> queryArticleForParentColumn(Integer id);

    /**
     * 根据文章标题搜索文章
     * @param articleTitle
     * @return
     */
    List<ArticleDO> search(String articleTitle);
}
