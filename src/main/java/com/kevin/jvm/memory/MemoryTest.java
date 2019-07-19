package com.kevin.jvm.memory;

/**
 * @author caonanqing
 * @version 1.0
 * @description     演示内存分配
 *
 *      设置参数：
 *          -verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M
 * @createDate 2019/7/13
 */
public class MemoryTest {

    public static void main(String[] args) {

        byte[] b1 = new byte[2*1024*1024];
        byte[] b2 = new byte[2*1024*1024];
        byte[] b3 = new byte[2*1024*1024];
        byte[] b4 = new byte[4*1024*1024];

        System.gc();
    }
}
