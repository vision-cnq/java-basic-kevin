package com.kevin.genericity;

/**
 * @author caonanqing
 * @version 1.0
 * @description      声明一个泛型类
 *      泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
 * @createDate 2019/6/6
 */
// T是泛型标识，T由外部指定
public class Box<T> {

    // 泛型标识
    private T data;

    public Box(){

    }

    // 将set/get方法设为泛型方法
    public Box(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }
}