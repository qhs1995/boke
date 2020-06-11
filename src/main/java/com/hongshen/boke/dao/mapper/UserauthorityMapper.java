package com.hongshen.boke.dao.mapper;

import com.hongshen.boke.dao.object.UserauthorityDO;
import com.hongshen.boke.dao.object.UserauthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/07/09
 */
public interface UserauthorityMapper {
    long countByExample(UserauthorityExample example);

    int deleteByExample(UserauthorityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserauthorityDO record);

    int insertSelective(UserauthorityDO record);

    List<UserauthorityDO> selectByExampleWithRowbounds(UserauthorityExample example, RowBounds rowBounds);

    List<UserauthorityDO> selectByExample(UserauthorityExample example);

    UserauthorityDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserauthorityDO record, @Param("example") UserauthorityExample example);

    int updateByExample(@Param("record") UserauthorityDO record, @Param("example") UserauthorityExample example);

    int updateByPrimaryKeySelective(UserauthorityDO record);

    int updateByPrimaryKey(UserauthorityDO record);
}