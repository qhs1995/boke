package com.hongshen.boke.dao.mapper;

import com.hongshen.boke.dao.object.ColumnDO;
import com.hongshen.boke.dao.object.ColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2018/11/12
 */
public interface ColumnMapper {
    long countByExample(ColumnExample example);

    int deleteByExample(ColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ColumnDO record);

    int insertSelective(ColumnDO record);

    List<ColumnDO> selectByExampleWithRowbounds(ColumnExample example, RowBounds rowBounds);

    List<ColumnDO> selectByExample(ColumnExample example);

    ColumnDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ColumnDO record, @Param("example") ColumnExample example);

    int updateByExample(@Param("record") ColumnDO record, @Param("example") ColumnExample example);

    int updateByPrimaryKeySelective(ColumnDO record);

    int updateByPrimaryKey(ColumnDO record);
}