package com.kevin.date;

import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description 使用sleep做休眠
 * @createDate 2018/12/19
 */
public class SleepDemo {

    public static void main(String args[]) {
        try {
            System.out.println(new Date( ) + "\n");
            Thread.sleep(1000*3);   // 休眠3秒
            System.out.println(new Date( ) + "\n");
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
    }
}
