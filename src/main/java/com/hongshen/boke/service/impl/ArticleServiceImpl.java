package com.hongshen.boke.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hongshen.boke.dao.mapper.ArticleMapper;
import com.hongshen.boke.dao.mapper.mymapper.MyArticleMapper;
import com.hongshen.boke.dao.object.ArticleDO;
import com.hongshen.boke.dao.object.ArticleExample;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.article.ArticleListResponse;
import com.hongshen.boke.response.article.ArticleQueryResponse;
import com.hongshen.boke.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/7 17:51
 * @Desc:
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private MyArticleMapper myArticleMapper;


    @Override
    public ResultResponse<List<ArticleListResponse>> list(Integer page,Integer limit) {
        ResultResponse<List<ArticleListResponse>> response = ResultResponse.create();
        try {
            PageHelper.startPage(page,limit);
            List<ArticleListResponse> list = myArticleMapper.list();
            if (list==null || list.size()<=0){
                return ResultResponse.successResponse("暂无数据！",null);
            }
            PageInfo<ArticleListResponse> pageInfo = new PageInfo<>(list);
            response.setCode(0);
            response.setMsg("查询成功");
            response.setCount(pageInfo.getTotal());
            response.setData(list);
            return response;
        } catch (Exception e) {
            logger.error("查询文章列表失败  错误信息=",e);
            return ResultResponse.failResponse(1,"查询文章列表失败,系统异常",null);
        }
    }

    @Override
    public ResultResponse<String> edit(ArticleDO articleDO) {
        articleDO.setCreatTime(new Date());
        if (articleDO.getId()!=null){
            try {
                articleMapper.updateByPrimaryKeySelective(articleDO);
                return ResultResponse.successResponse("修改成功",null);
            } catch (Exception e) {
                logger.error("修改文章失败，id={}  文章主题={}  错误信息=",articleDO.getId(),articleDO.getTitle(),e);
                return ResultResponse.failResponse(1,"修改文章失败,系统异常",null);
            }
        }
        try {
            articleMapper.insertSelective(articleDO);
        } catch (Exception e) {
            logger.error("添加文章失败，  文章主题={}  错误信息=",articleDO.getTitle(),e);
            return ResultResponse.failResponse(1,"添加文章失败,系统异常",null);
        }
        return ResultResponse.successResponse("添加成功",null);
    }


    @Override
    public ResultResponse<ArticleDO> query(Integer id) {
        ArticleQueryResponse queryResponse =null;
        try {
             //articleDO = articleMapper.selectByPrimaryKey(id);
             queryResponse = myArticleMapper.queryById(id);
            if (queryResponse ==null){
                return ResultResponse.successResponse("查询成功，暂无数据！",null);
            }
        } catch (Exception e) {
            logger.error("查询文章失败, id={}  错误信息=",id,e);
            return ResultResponse.failResponse(1,"查询文章失败,系统异常",null);
        }
        return ResultResponse.successResponse("查询成功！",queryResponse);
    }

    @Override
    public ResultResponse<String> delete(Integer id) {
        try {
            articleMapper.deleteByPrimaryKey(id);
            return ResultResponse.successResponse("删除成功",null);
        } catch (Exception e) {
            logger.error("删除文章失败  错误信息",e);
            return ResultResponse.failResponse(1,"删除文章失败",null);
        }
    }

    @Override
    public List<ArticleDO> queryArticleForChildColumn(Integer id) {
        try {
            ArticleExample example = new ArticleExample();
            example.createCriteria().andColumnIdEqualTo(id);
            List<ArticleDO> articleDOList = articleMapper.selectByExample(example);
            return articleDOList;
        } catch (Exception e) {
            logger.error("查询栏目下的文章失败  错误原因=",e);
            return null;
        }
    }

    @Override
    public List<ArticleDO> queryArticleForParentColumn(Integer id) {
        try {
            List<ArticleDO> articleDOList = myArticleMapper.queryArticleForParentColumn(id);
            return articleDOList;
        } catch (Exception e) {
            logger.error("查询父栏目下的文章失败 错误信息=",e);
            return null;
        }
    }


    @Override
    public List<ArticleDO> search(String articleTitle) {
        if (StringUtils.isEmpty(articleTitle)){
            return null;
        }
        try {
            List<ArticleDO> articleDOList = myArticleMapper.queryByTitle(articleTitle);
            return articleDOList;
        } catch (Exception e) {
            logger.error("搜索文章失败 标题内容={} 错误信息=",articleTitle,e);
            return null;
        }
    }

}
