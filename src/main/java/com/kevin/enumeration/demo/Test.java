package com.kevin.enumeration.demo;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/15
 */
public class Test {

    public static void main(String[] args) {

        int status = 200;
        // 状态码
        String type = StatusEnum.codeMessage(status);
        System.out.println(type);
    }
}
