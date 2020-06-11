package com.hongshen.boke.dao.jianli.mapper;

import com.hongshen.boke.dao.jianli.object.StatisticsDO;
import com.hongshen.boke.dao.jianli.object.StatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 该接口类是由系统生成请勿修改
 *
 * Created by system on 2019/09/24
 */
public interface StatisticsMapper {
    long countByExample(StatisticsExample example);

    int deleteByExample(StatisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StatisticsDO record);

    int insertSelective(StatisticsDO record);

    List<StatisticsDO> selectByExampleWithRowbounds(StatisticsExample example, RowBounds rowBounds);

    List<StatisticsDO> selectByExample(StatisticsExample example);

    StatisticsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StatisticsDO record, @Param("example") StatisticsExample example);

    int updateByExample(@Param("record") StatisticsDO record, @Param("example") StatisticsExample example);

    int updateByPrimaryKeySelective(StatisticsDO record);

    int updateByPrimaryKey(StatisticsDO record);
}