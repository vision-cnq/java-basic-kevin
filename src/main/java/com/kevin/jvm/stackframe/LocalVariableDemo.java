package com.kevin.jvm.stackframe;

/**
 * @author caonanqing
 * @version 1.0
 * @description     局部变量表
 * @createDate 2019/8/3
 */
public class LocalVariableDemo {

    /**
     * 全局变量两次赋值：
     *  1.加载时，会赋予一个默认值。
     *  2.在初始化时，会赋予自定义的
     */
    private int a;

    private int b;

    public int add(){
        return a+b;
    }

    public int add2(){
        // 但是局部变量表是没有初始值的
        int a;
        int b;

        return 0;
    }

}
