package com.kevin.genericity.demo;

/**
 * @author caonanqing
 * @version 1.0
 * @description     实现泛型接口
 * @createDate 2019/6/6
 */
public class Major<T> implements Subject<T> {

    @Override
    public <T> T show(T data) {
        return data;
    }

}
