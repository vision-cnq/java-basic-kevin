package com.kevin.reflect;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/6
 */
public class Person {

    String name;
    private int age;

    public Person() {
        super();
    }

    //包含一个带参的构造器和一个不带参的构造器
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
