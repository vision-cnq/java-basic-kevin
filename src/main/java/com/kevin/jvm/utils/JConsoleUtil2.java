package com.kevin.jvm.utils;

import java.util.Scanner;

/**
 * @author caonanqing
 * @version 1.0
 * @description     演示JConsole虚拟机工具对线程的监控
 * @createDate 2019/7/19
 */
public class JConsoleUtil2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.next();

        // 创建一个线程启动并处于等待期间
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        },"WhileTrue").start();
        sc.next();
        testWait(new Object());
    }

    private static void testWait(Object obj) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        },"Wait").start();
    }
}
