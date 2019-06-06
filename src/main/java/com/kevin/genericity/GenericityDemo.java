package com.kevin.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description     举例：为什么要使用泛型
 * @createDate 2019/6/6
 */
public class GenericityDemo {

    public static void main(String[] args) {

        // 不使用泛型时,list可以存放任意类型，会当成Object

        /*
        ArrayList list = new ArrayList();
        list.add("qq");
        list.add("wx");
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            // 抛出异常java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
            String value = (String) list.get(i);    // 在第三个元素的时候是int，转成String失败
            System.out.println(value);
        }*/


        // 使用泛型时，设置类型为String
        List<String> list = new ArrayList<>();
        list.add("qq");
        list.add("wx");
        // list.add(5); 添加该元素时会提示编译错误，因为类型不同

        for (int i = 0; i < list.size(); i++) {
            String value = list.get(i);     // 不会抛出异常，因为类型一致
            System.out.println(value);
        }

    }
}
