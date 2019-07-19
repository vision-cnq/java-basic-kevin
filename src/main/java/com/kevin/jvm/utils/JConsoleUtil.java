package com.kevin.jvm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description     演示JConsole虚拟机工具对内存的监控
 * @createDate 2019/7/19
 */
public class JConsoleUtil {

    public byte[] b1 = new byte[128 * 1024];

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start...");
        fill(1000);
    }

    private static void fill(int n) {
        List<JConsoleUtil> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new JConsoleUtil());
        }
    }
}
