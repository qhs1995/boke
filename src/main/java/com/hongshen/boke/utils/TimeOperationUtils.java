package com.hongshen.boke.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/25 16:43
 * @Desc: 时间运算
 */
public class TimeOperationUtils {
    private static final Logger logger = LoggerFactory.getLogger(TimeOperationUtils.class);

    /**
     * 时间加减计算
     * @param date  需要计算的时间
     * @param calendar 传入Calendar的成员变量 如传入Calendar.MINUTE 表示进行分钟的计算
     * @param time 需要在传入的时间上相加则传入正数   相减则传入负数
     * @return
     */
    public static Date operation(Date date, Integer calendar,Integer time){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendar,time);
        return c.getTime();
    }


    public static void main(String[] args) {
        Date date = operation(new Date(), Calendar.DATE, 6);
        System.out.println(date);
    }
}
