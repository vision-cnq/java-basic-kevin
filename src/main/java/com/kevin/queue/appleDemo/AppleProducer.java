package com.kevin.queue.appleDemo;

import java.util.concurrent.BlockingQueue;

/**
 * @author kevin
 * @version 1.0
 * @description     定义苹果生成者
 * @createDate 2019/3/27
 */
public class AppleProducer implements Runnable{

    private final BlockingQueue<String> queue;
    private final int size;

    public AppleProducer(BlockingQueue<String> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    // 对队列加锁
    @Override
    public void run() {
        try {
            while (true){
                synchronized (queue) {
                    queue.put("An Apple");
                    System.out.println("生产者："+Thread.currentThread().getName() + "生产了1个苹果，当前有：" + queue.size() + "个苹果，当前时间：" + System.currentTimeMillis());
                    if(queue.size() >= size){
                        queue.wait();   // 释放锁
                        //Thread.sleep(1000);
                    }else{
                        queue.notify(); // 数据达到容量的顶峰，必须消费，所以释放锁
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 不对队列加锁，如果有多个线程同时在消费，那这样数据就会丢失
    /*@Override
    public void run() {
        while (true){
            try{
                queue.put("An Apple");
                System.out.println("生产者："+Thread.currentThread().getName() + "生产了1个苹果，当前有：" + queue.size() + "个苹果，当前时间：" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }*/

}
