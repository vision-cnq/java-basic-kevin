package com.kevin.regex;

import java.util.Arrays;

/**
 * @author kevin
 * @version 1.0
 * @description     测试正则表达式对象的分割字符串的操作
 * @createDate 2018/12/25
 */
public class RegexDemo4 {

    public static void main(String[] args) {
        String str = "a232b4334c3434";
        String[] arrs = str.split("\\d+");
        System.out.println(Arrays.toString(arrs));

    }
}
