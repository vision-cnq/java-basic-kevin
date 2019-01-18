package com.kevin.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description     使用SimpleDateFormat格式化日期
 * @createDate 2018/12/19
 */
public class DateDemo2 {

    public static void main(String args[]) {

        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

        System.out.println("当前时间为: " + ft.format(dNow));
    }
}
