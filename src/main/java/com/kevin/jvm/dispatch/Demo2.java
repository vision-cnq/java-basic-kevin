package com.kevin.jvm.dispatch;

import java.io.Serializable;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试静态分派
 * @createDate 2019/8/3
 */
public class Demo2 {

    public void sayHello(int a){
        System.out.println("int !");
    }
    public void sayHello(char a){
        System.out.println("char !");
    }
    public void sayHello(Object a){
        System.out.println("Object !");
    }
    public void sayHello(Character a){
        System.out.println("Character !");
    }
    public void sayHello(Serializable a){
        System.out.println("Serializable !");
    }
    public void sayHello(char... a){
        System.out.println("char... !");
    }

    public static void main(String[] args) {
        Demo2 d = new Demo2();
        d.sayHello('a');
    }
}
