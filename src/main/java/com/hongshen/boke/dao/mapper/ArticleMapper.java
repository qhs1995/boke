package com.hongshen.boke.dao.mapper;

import com.hongshen.boke.dao.object.ArticleDO;
import com.hongshen.boke.dao.object.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2018/12/04
 */
public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleDO record);

    int insertSelective(ArticleDO record);

    List<ArticleDO> selectByExampleWithBLOBsWithRowbounds(ArticleExample example, RowBounds rowBounds);

    List<ArticleDO> selectByExampleWithBLOBs(ArticleExample example);

    List<ArticleDO> selectByExampleWithRowbounds(ArticleExample example, RowBounds rowBounds);

    List<ArticleDO> selectByExample(ArticleExample example);

    ArticleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleDO record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleDO record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") ArticleDO record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(ArticleDO record);

    int updateByPrimaryKeyWithBLOBs(ArticleDO record);

    int updateByPrimaryKey(ArticleDO record);
}