package com.hongshen.boke.jianli.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/24 17:31
 * @Desc: 接口访问统计
 */
public interface StatisticsService {

    /**
     * 查询规定时间内是否访问发送邮件接口  （指定五分钟 ）
     * @param ip
     * @return  未发送过返回值为 false   否则为true
     */
    Boolean queryRegulationTimeIsSendEmail(String ip);
}
