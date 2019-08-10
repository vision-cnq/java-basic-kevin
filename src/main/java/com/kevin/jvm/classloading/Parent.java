package com.kevin.jvm.classloading;

/**
 * @author caonanqing
 * @version 1.0
 * @description         测试类加载的初始化
 * @createDate 2019/8/1
 */
public class Parent {

    static {
        System.out.println("parent 初始化了...");
    }

    public static int num = 10;
}
