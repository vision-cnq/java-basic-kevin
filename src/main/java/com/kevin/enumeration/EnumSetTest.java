package com.kevin.enumeration;

import java.util.EnumSet;

/**
 * @author caonanqing
 * @version 1.0
 * @description     EnumSet的使用
 *
 *      EnumSet保证集合中的元素不重复
 * @createDate 2019/6/3
 */
public class EnumSetTest {

    public static void main(String[] args) {

        // EnumSet的使用
        EnumSet<EnumMethod> weekSet = EnumSet.allOf(EnumMethod.class);
        for (EnumMethod day : weekSet) {
            System.out.println(day);
        }

    }
}
