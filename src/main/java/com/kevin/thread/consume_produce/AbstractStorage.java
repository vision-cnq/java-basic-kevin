package com.kevin.thread.consume_produce;

/**
 * @author caonanqing
 * @version 1.0
 * @description     抽象仓库类
 * @createDate 2019/5/31
 */
public interface AbstractStorage {

    void consume(int num);
    void produce(int num);
}
