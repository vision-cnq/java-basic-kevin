package com.kevin.date;

import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description 比较时间间隔
 * @createDate 2018/12/19
 */
public class DiffDemo {

    public static void main(String args[]) {
        try {
            long start = System.currentTimeMillis( );
            System.out.println(new Date( ) + "\n");
            Thread.sleep(5*60*10);  //休眠3秒
            System.out.println(new Date( ) + "\n");
            long end = System.currentTimeMillis( );
            long diff = end - start;
            System.out.println("Difference is : " + diff);
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
    }
}
