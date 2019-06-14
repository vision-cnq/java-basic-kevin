package com.kevin.reflect;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/6
 */
public class Person{

    String name;
    private Integer age;

    public Person() {
        super();
    }

    //包含一个带参的构造器和一个不带参的构造器
    public Person(String name, Integer age) {
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
    public Integer getAge() {
        return age;
    }

    @AgeValidator(min=18,max=35)    // 该注解是自己自定义的，只能用在方法上
    public void setAge(Integer age) {
        this.age = age;
    }

    // 测试方法
    private String testMethod(String name){
        this.name = name;
        return name + this.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
