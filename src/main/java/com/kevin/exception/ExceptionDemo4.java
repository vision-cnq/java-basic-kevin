package com.kevin.exception;

/**
 * @author kevin
 * @version 1.0
 * @description     自定义异常信息
 * @createDate 2018/12/24
 */
public class ExceptionDemo4 {

    public static void main(String[] args) {
        Person  p  =  new Person();
        p.setAge(-10);
    }
}

class Person {
    private int age;
    public int getAge(){
        return  age;
    }
    public void setAge(int age){
        if(age<0){
            try {
                throw new IllegalAgeException("年龄不能小于0岁");
            } catch (IllegalAgeException e) {
                e.printStackTrace();
            }
        }
        this.age = age;
    }
}

class IllegalAgeException extends Exception{
    public IllegalAgeException(){}

    public IllegalAgeException(String msg){
        super(msg);
    }
}

