package com.kevin.jvm.utils;

import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description     演示线程信息，与Jstack虚拟机工具比较类似
 * @createDate 2019/7/13
 */
public class JstackUtil {

    public static void main(String[] args) {

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for(Map.Entry<Thread, StackTraceElement[]> en: map.entrySet()){
            Thread t = en.getKey();
            StackTraceElement[] v = en.getValue();
            System.out.println("Thread Name is " + t.getName());
            for(StackTraceElement s : v) {
                System.out.println("\t"+s.toString());
            }
        }
    }
}
