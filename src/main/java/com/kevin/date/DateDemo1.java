package com.kevin.date;

import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description     打印当前时间并用toString()打印
 * @createDate 2018/12/19
 */
public class DateDemo1 {

    public static void main(String args[]) {
        // 初始化 Date 对象
        Date date = new Date();

        // 使用 toString() 函数显示日期时间
        System.out.println(date.toString());
    }
}
