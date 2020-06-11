package com.hongshen.boke.dao.jianli.mapper;

import com.hongshen.boke.dao.jianli.object.SkillDO;
import com.hongshen.boke.dao.jianli.object.SkillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/09/23
 */
public interface SkillMapper {
    long countByExample(SkillExample example);

    int deleteByExample(SkillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkillDO record);

    int insertSelective(SkillDO record);

    List<SkillDO> selectByExampleWithRowbounds(SkillExample example, RowBounds rowBounds);

    List<SkillDO> selectByExample(SkillExample example);

    SkillDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkillDO record, @Param("example") SkillExample example);

    int updateByExample(@Param("record") SkillDO record, @Param("example") SkillExample example);

    int updateByPrimaryKeySelective(SkillDO record);

    int updateByPrimaryKey(SkillDO record);
}