package com.kevin.thread.consume_produce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/31
 */
public class Test {

    public static void main(String[] args) {

        // 仓库对象
        AbstractStorage storage = new Storage();

        ExecutorService service = Executors.newCachedThreadPool();

        // 创建10个生产者
        for (int i = 0; i < 10; i++) {
            Producer producer = new Producer(storage);
            service.execute(producer);
            producer.setNum(10);

        }
        // 创建3个消费者
        for (int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(storage);
            service.execute(consumer);
            consumer.setNum(50);
        }

        service.shutdown();
    }
}
