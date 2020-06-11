package com.hongshen.boke.dao.mapper;

import com.hongshen.boke.dao.object.TouristDO;
import com.hongshen.boke.dao.object.TouristExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2018/12/04
 */
public interface TouristMapper {
    long countByExample(TouristExample example);

    int deleteByExample(TouristExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TouristDO record);

    int insertSelective(TouristDO record);

    List<TouristDO> selectByExampleWithRowbounds(TouristExample example, RowBounds rowBounds);

    List<TouristDO> selectByExample(TouristExample example);

    TouristDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TouristDO record, @Param("example") TouristExample example);

    int updateByExample(@Param("record") TouristDO record, @Param("example") TouristExample example);

    int updateByPrimaryKeySelective(TouristDO record);

    int updateByPrimaryKey(TouristDO record);
}