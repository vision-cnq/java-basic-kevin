package com.kevin.thread.consume_produce;

/**
 * @author caonanqing
 * @version 1.0
 * @description     生产者
 * @createDate 2019/5/31
 */
public class Producer implements Runnable{

    // 每次生产的数量
    private int num;

    // 所属的仓库
    public AbstractStorage abstractStorage;

    public Producer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    public void setNum (int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // 调用仓库Storage的生产函数
        abstractStorage.produce(num);
    }
}
