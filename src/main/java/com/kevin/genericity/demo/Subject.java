package com.kevin.genericity.demo;

/**
 * @author caonanqing
 * @version 1.0
 * @description     泛型接口
 * @createDate 2019/6/6
 */
public interface Subject<T> {

    public <T> T show(T data);
}
