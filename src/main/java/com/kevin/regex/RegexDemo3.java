package com.kevin.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kevin
 * @version 1.0
 * @description     测试正则表达式对象的替换操作
 * @createDate 2018/12/25
 */
public class RegexDemo3 {

    public static void main(String[] args) {
        //表达式对象
        Pattern p = Pattern.compile("[0-9]");
        //创建Matcher对象
        Matcher m = p.matcher("aa232**ssd445*sds223");
        //替换
        String newStr = m.replaceAll("#");
        System.out.println(newStr);


    }
}
