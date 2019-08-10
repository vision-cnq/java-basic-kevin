package com.kevin.jvm.classloading;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/8/1
 */
public class Child extends Parent {

    public static final int a = 20;

    static {
        System.out.println("child 初始化...");
    }

}
