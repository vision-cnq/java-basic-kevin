package com.kevin.jvm.classz;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试class文件中的常量池，访问标志，类索引和父类索引和接口索引集合，字段表。
 *      javap -verbose TestConstant
 * @createDate 2019/7/30
 */
public class TestConstant {

    private final int a = 10;
    private final int b = 10;
    private int c = 11;
    private int d = 11;
    private long e = -11111110005514L;
    private long f = -11111110005514L;
    private double g = 10.4557848D;
    private double h = 10.4557848D;
    private String y = "JVM";
    private String j = "JVM";
}
