package com.hongshen.boke.dao.jianli.mapper;

import com.hongshen.boke.dao.jianli.object.WorkDO;
import com.hongshen.boke.dao.jianli.object.WorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/09/25
 */
public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkDO record);

    int insertSelective(WorkDO record);

    List<WorkDO> selectByExampleWithRowbounds(WorkExample example, RowBounds rowBounds);

    List<WorkDO> selectByExample(WorkExample example);

    WorkDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkDO record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") WorkDO record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(WorkDO record);

    int updateByPrimaryKey(WorkDO record);
}