package com.kevin.thread.consume_produce;

/**
 * @author caonanqing
 * @version 1.0
 * @description     消费者
 * @createDate 2019/5/31
 */
public class Consumer implements Runnable{

    // 每次消费的产品数量
    private int num;

    // 所在防止的仓库
    private AbstractStorage abstractStorage;

    // 设置仓库
    public Consumer(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // 调用仓库Storage的生产函数
        abstractStorage.consume(num);
    }
}
