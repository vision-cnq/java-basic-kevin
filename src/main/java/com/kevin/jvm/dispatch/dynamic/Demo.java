package com.kevin.jvm.dispatch.dynamic;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试动态分派
 * @createDate 2019/8/3
 */
public class Demo {

    static class Parent{
        public void sayHello(){
            System.out.println("parent");
        }
    }

    static class Child1 extends Parent {
        @Override
        public void sayHello() {
            System.out.println("child1");
        }
    }

    static class Child11 extends Child1 {
        @Override
        public void sayHello() {
            System.out.println("child11");
        }
    }

    static class Child2 extends Parent {
        @Override
        public void sayHello() {
            System.out.println("child2");
        }
    }

    public static void main(String[] args) {
        Parent p1 = new Child11();
        Parent p2 = new Child2();

        p1.sayHello();
        p2.sayHello();

    }
}
