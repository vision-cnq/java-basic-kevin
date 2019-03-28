package com.kevin.queue.appleDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kevin
 * @version 1.0
 * @description     测试queue队列的案例
 * @createDate 2019/3/27
 */
public class AppleBlockingQueueTest {

    public static void main(String[] args) {

        int queueSize = 10;
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(queueSize);

        ExecutorService service = Executors.newCachedThreadPool();
        //AppleProducer producer = new AppleProducer(queue);
        //AppleConsumer consumer = new AppleConsumer(queue);

        service.submit(new AppleProducer(queue,queueSize));
        for(int i=0;i<10;i++){
            service.submit(new AppleConsumer(queue,queueSize));
        }

        // 程序运行10s后，所有任务停止
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        service.shutdownNow();*/
    }

}
