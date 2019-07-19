package com.kevin.jvm.utils;

/**
 * @author caonanqing
 * @version 1.0
 * @description         演示JConsole虚拟机工具对线程死锁监控
 * @createDate 2019/7/19
 */
public class JConsoleUtil3 {

    public static void main(String[] args) {

        Object obj1 = new Object();
        Object obj2 = new Object();

        new Thread(new DeadLock(obj1,obj2)).start();
        new Thread(new DeadLock(obj2,obj1)).start();

    }
}
