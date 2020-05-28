package com.kevin.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author caonanqing
 * @version 1.0
 * @description     创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 * @createDate 2019/5/31
 */
public class SingleThreadExecutorDemo {

    public static void main(String[] args) {

        // 该线程池只有一个线程，结果依次输出，相当于顺序执行各个任务。
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            service.execute(new SingleDemo());
        }
    }
}

// 测试线程
class SingleDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +"___"+ i);
        }

        try {
            // 休眠2秒
            Thread.sleep(2000L);
            System.out.println("休眠2秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}