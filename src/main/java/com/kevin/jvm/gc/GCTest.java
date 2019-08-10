package com.kevin.jvm.gc;

/**
 * @author caonanqing
 * @version 1.0
 * @description     演示垃圾回收机制的引用计数算法不能检测出循环引用。
 *      打印
 *      参数设置：-XX:+PrintGCDetails
 *      查看内存的变化：-verbose:gc
 * @createDate 2019/7/12
 */
public class GCTest {

    private Object instance;

    public static void main(String[] args) {

        GCTest d1 = new GCTest();
        GCTest d2 = new GCTest();

        // 相互引用对方
        d1.instance = d2;
        d2.instance = d1;

        // 将它们设为null，表示指向的对象不可能被引用。
        d1 = null;
        d2 = null;

        // 由于相互引用对方，导致它们的引用计数器无法设置为0，那么垃圾收集器就永远无法回收它们
        System.gc();

    }
}
