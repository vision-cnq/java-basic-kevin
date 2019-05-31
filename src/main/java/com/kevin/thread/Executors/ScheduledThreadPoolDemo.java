package com.kevin.thread.Executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author caonanqing
 * @version 1.0
 * @description     创建一个定长线程池，支持定时及周期性任务执行。延迟执行
 * @createDate 2019/5/31
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        // 设置线程池大小为5
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        // 执行10个线程，由于线程池中只有5个，所以在线程池中没有空闲线程时，会等待有线程时再执行
        /*for (int i = 0; i < 10; i++) {
            service.execute(new ScheduledDemo());
        }*/

        // 线程会延迟执行
        // 比如延迟3秒后执行
        service.schedule(new ScheduledDemo(), 3, TimeUnit.SECONDS);
        // 比如延迟1秒后每3秒执行一次。
        service.scheduleAtFixedRate(new ScheduledDemo(),1,3,TimeUnit.SECONDS);

    }
}

// 测试线程
class ScheduledDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() +"___"+ i);
        }
    }
}
