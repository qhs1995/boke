package com.hongshen.boke.dao.jianli.mapper;

import com.hongshen.boke.dao.jianli.object.UserinfoDO;
import com.hongshen.boke.dao.jianli.object.UserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/09/23
 */
public interface UserinfoMapper {
    long countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserinfoDO record);

    int insertSelective(UserinfoDO record);

    List<UserinfoDO> selectByExampleWithRowbounds(UserinfoExample example, RowBounds rowBounds);

    List<UserinfoDO> selectByExample(UserinfoExample example);

    UserinfoDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserinfoDO record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") UserinfoDO record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(UserinfoDO record);

    int updateByPrimaryKey(UserinfoDO record);
}