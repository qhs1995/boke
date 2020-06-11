package com.hongshen.boke.jianli.service.impl;

import com.hongshen.boke.dao.jianli.mapper.StatisticsMapper;
import com.hongshen.boke.dao.jianli.object.StatisticsDO;
import com.hongshen.boke.dao.jianli.object.StatisticsExample;
import com.hongshen.boke.jianli.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/24 17:31
 * @Desc:
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    @Autowired
    private StatisticsMapper statisticsMapper;


    @Override
    public Boolean queryRegulationTimeIsSendEmail(String ip) {
        Calendar c = Calendar.getInstance();
        //五分钟内是否已经发送过邮件
        c.setTime(new Date());
        c.add(Calendar.MINUTE, - 5);
        Date time = c.getTime();
        StatisticsExample example = new StatisticsExample();
        example.createCriteria().andIpEqualTo(ip).andInterfaceNameEqualTo("/jianli/sendEmail").andUpdateTimeGreaterThanOrEqualTo(time);
        List<StatisticsDO> list = statisticsMapper.selectByExample(example);
        if (list.size() == 0){
            return false;
        }
        return true;
    }
}
