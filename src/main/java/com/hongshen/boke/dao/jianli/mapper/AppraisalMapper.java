package com.hongshen.boke.dao.jianli.mapper;

import com.hongshen.boke.dao.jianli.object.AppraisalDO;
import com.hongshen.boke.dao.jianli.object.AppraisalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/09/23
 */
public interface AppraisalMapper {
    long countByExample(AppraisalExample example);

    int deleteByExample(AppraisalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppraisalDO record);

    int insertSelective(AppraisalDO record);

    List<AppraisalDO> selectByExampleWithRowbounds(AppraisalExample example, RowBounds rowBounds);

    List<AppraisalDO> selectByExample(AppraisalExample example);

    AppraisalDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppraisalDO record, @Param("example") AppraisalExample example);

    int updateByExample(@Param("record") AppraisalDO record, @Param("example") AppraisalExample example);

    int updateByPrimaryKeySelective(AppraisalDO record);

    int updateByPrimaryKey(AppraisalDO record);
}