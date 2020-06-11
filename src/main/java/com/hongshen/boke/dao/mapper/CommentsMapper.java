package com.hongshen.boke.dao.mapper;

import com.hongshen.boke.dao.object.CommentsDO;
import com.hongshen.boke.dao.object.CommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2018/12/04
 */
public interface CommentsMapper {
    long countByExample(CommentsExample example);

    int deleteByExample(CommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentsDO record);

    int insertSelective(CommentsDO record);

    List<CommentsDO> selectByExampleWithRowbounds(CommentsExample example, RowBounds rowBounds);

    List<CommentsDO> selectByExample(CommentsExample example);

    CommentsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentsDO record, @Param("example") CommentsExample example);

    int updateByExample(@Param("record") CommentsDO record, @Param("example") CommentsExample example);

    int updateByPrimaryKeySelective(CommentsDO record);

    int updateByPrimaryKey(CommentsDO record);
}