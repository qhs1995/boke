package com.hongshen.boke.dao.mapper;

import com.hongshen.boke.dao.object.TbfileDO;
import com.hongshen.boke.dao.object.TbfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2018/11/14
 */
public interface TbfileMapper {
    long countByExample(TbfileExample example);

    int deleteByExample(TbfileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbfileDO record);

    int insertSelective(TbfileDO record);

    List<TbfileDO> selectByExampleWithBLOBsWithRowbounds(TbfileExample example, RowBounds rowBounds);

    List<TbfileDO> selectByExampleWithBLOBs(TbfileExample example);

    List<TbfileDO> selectByExampleWithRowbounds(TbfileExample example, RowBounds rowBounds);

    List<TbfileDO> selectByExample(TbfileExample example);

    TbfileDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbfileDO record, @Param("example") TbfileExample example);

    int updateByExampleWithBLOBs(@Param("record") TbfileDO record, @Param("example") TbfileExample example);

    int updateByExample(@Param("record") TbfileDO record, @Param("example") TbfileExample example);

    int updateByPrimaryKeySelective(TbfileDO record);

    int updateByPrimaryKeyWithBLOBs(TbfileDO record);

    int updateByPrimaryKey(TbfileDO record);
}