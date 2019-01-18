package com.kevin.date;

import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description 需要重复提供日期，那么利用这种方式来格式化它的每一部分就有点复杂了。
 * 因此，可以利用一个格式化字符串指出要被格式化的参数的索引。
 * 索引必须紧跟在%后面，而且必须以$结束。
 * @createDate 2018/12/19
 */
public class DateDemo4 {

    public static void main(String args[]) {
        test1();
        System.out.println();
        test2();
    }

    //使用 %与$ 标志
    public static void test1(){
        // 初始化 Date 对象
        Date date = new Date();

        // 使用toString()显示日期和时间
        System.out.printf("%1$s %2$tB %2$td, %2$tY",
                "Due date:", date);
    }

    //使用 < 标志
    public static void test2(){
        // 初始化 Date 对象
        Date date = new Date();

        // 显示格式化时间
        System.out.printf("%s %tB %<te, %<tY",
                "Due date:", date);
    }
}
