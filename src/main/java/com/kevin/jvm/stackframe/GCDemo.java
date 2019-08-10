package com.kevin.jvm.stackframe;

/**
 * @author caonanqing
 * @version 1.0
 * @description     在vm配置中添加：-verbose:gc
 *      查看内存的变化
 * @createDate 2019/8/3
 */
public class GCDemo {

    public static void main(String[] args) {
        {
            byte[] buff = new byte[60 * 1024 * 1024];
        }
        int i = 0;
        System.gc();
    }
}
