package com.kevin.jvm.dispatch;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试静态分派
 * @createDate 2019/8/3
 */
public class Demo {

    static class Parent{}

    static class Child1 extends Parent{}

    static class Child2 extends Parent{}

    public void sayHello(Child1 c){
        System.out.println("c1 is call");
    }

    public void sayHello(Child2 c){
        System.out.println("c2 is call");
    }

    public void sayHello(Parent p){
        System.out.println("p is call");
    }

    public static void main(String[] args) {
        // 父类称为变量的静态类型，子类称为变量的实际类型
        Parent p1 = new Child1();
        Parent p2 = new Child2();

        Demo d = new Demo();
        // 选择的时候根据静态来选择。称为静态类型
        d.sayHello(p1);
        d.sayHello(p2);

        // 实际类型发生改变
        Parent p = new Child1();
        p = new Child2();

        // 静态类型发生变化
        d.sayHello((Child2)p);

    }
}
