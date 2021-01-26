package com.xzm.video.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-01-25 19:19
 */
public class DateUtils{

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 获取当前系统时间字符串
     * @param format
     * @return
     */
    public static String getCurrentDateStr(String format){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String currentTime = sdf.format(date);
        return currentTime;
    }

    /**
     * 将日期字符串转化为需要格式的日期
     * @param date 日期字符串
     * @param format 格式字符串
     * @return	转换后的日期对象
     */
    public static Date strToFormatDate(String date, String format){
        if(date == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date, new ParsePosition(0));
    }

    /**
     * 将字符串转换为yyyy-MM-dd格式的日期
     * @param date
     * @return	转换后的日期对象
     */
    public static Date strToDate(String date){
        return DateUtils.strToFormatDate(date, DATE_FORMAT);
    }

    /**
     * 将字符串转换为yyyy-MM-dd HH:mm:ss格式的日期
     * @param date
     * @return	转换后的日期对象
     */
    public static Date strToDateTime(String date){
        return DateUtils.strToFormatDate(date, TIME_FORMAT);
    }

}

