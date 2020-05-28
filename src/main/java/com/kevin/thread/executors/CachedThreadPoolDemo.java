package com.kevin.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 *      创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * @createDate 2019/5/31
 */
public class CachedThreadPoolDemo {

    public static void main(String[] args) {

        // 创建newCachedThreadPool线程池
        ExecutorService service = Executors.newCachedThreadPool();
        // 创建10个线程
        for (int i = 0; i < 10; i++) {
            // 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
            service.execute(new CachedDemo());
            try {
                // 休眠2秒
                Thread.sleep(2000L);
                System.out.println("休眠2秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 测试线程
class CachedDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +"___"+ i);
        }
    }

}