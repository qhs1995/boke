package com.hongshen.boke.dao.jianli.mapper;

import com.hongshen.boke.dao.jianli.object.ProjectDO;
import com.hongshen.boke.dao.jianli.object.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/09/25
 */
public interface ProjectMapper {
    long countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectDO record);

    int insertSelective(ProjectDO record);

    List<ProjectDO> selectByExampleWithBLOBsWithRowbounds(ProjectExample example, RowBounds rowBounds);

    List<ProjectDO> selectByExampleWithBLOBs(ProjectExample example);

    List<ProjectDO> selectByExampleWithRowbounds(ProjectExample example, RowBounds rowBounds);

    List<ProjectDO> selectByExample(ProjectExample example);

    ProjectDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectDO record, @Param("example") ProjectExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectDO record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") ProjectDO record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(ProjectDO record);

    int updateByPrimaryKeyWithBLOBs(ProjectDO record);

    int updateByPrimaryKey(ProjectDO record);
}