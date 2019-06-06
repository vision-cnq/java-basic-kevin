package com.kevin.genericity.demo;

/**
 * @author caonanqing
 * @version 1.0
 * @description     定义泛型类
 * @createDate 2019/6/6
 */
public class Student<T> {

    private T data;

    public Student() {
    }

    public Student(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Student{" +
                "data=" + data +
                '}';
    }
}
