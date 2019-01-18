package com.kevin.util;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @title
 * @description     时间转换工具
 * @author caonanqing
 * @createDate 2019/1/10
 * @version 1.0
 */
public class DateUtils {

    public static Logger LOGGER = Logger.getLogger(DateUtils.class);
    // 时间格式
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 将从1970-1-1 08:00:00开始的秒数转成指定时间，北京时间，所以增加8个小时
     * @param second    秒数
     * @return
     */
    public static String secondToDate(int second){
        Calendar c = Calendar.getInstance();
        c.set(1970,0,1,8,0,0);
        c.add(Calendar.SECOND,second);
        return sdf.format(c.getTime());
    }

    /**
     *  将字符串转为int类型，如果不能转换则赋值0
     * @param value
     * @return
     */
    public static int valueToInt(String key, String value){
        int result = 0;
        try{
            result = Integer.parseInt(value);
        }catch (Exception e){
            LOGGER.warn("Name: "+key+" ,Value: "+value+"，无法转成int，返回: "+result);
        }
        return result;
    }
}
