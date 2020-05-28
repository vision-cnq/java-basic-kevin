package com.kevin.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 *      创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * @createDate 2019/5/31
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {

        // 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
        // 设置线程池容量为3
        ExecutorService service = Executors.newFixedThreadPool(3);

        System.out.println("系统资源推荐创建" + Runtime.getRuntime().availableProcessors() + "个线程");

        // 因为线程池大小为3，当3个线程都在使用时，会等待有空闲线程时才会继续执行任务
        for (int i = 0; i < 10; i++) {
            service.execute(new FixedDemo());
        }
    }
}

// 测试线程
class FixedDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +"___"+ i);
        }
        // 休眠2秒
        try {
            Thread.sleep(2000L);
            System.out.println("休眠2秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
