package com.kevin.queue.appleDemo;

import java.util.concurrent.BlockingQueue;

/**
 * @author kevin
 * @version 1.0
 * @description     定义苹果消费者
 * @createDate 2019/3/27
 */
public class AppleConsumer implements Runnable {

    private final BlockingQueue<String> queue;
    private final int size;

    public AppleConsumer(BlockingQueue<String> queue,int size) {
        this.queue = queue;
        this.size = size;
    }

    // 对队列加锁
    @Override
    public void run() {
        try {
            while (true) {
                if(queue.size() > 0) {
                    synchronized(queue) {
                        System.out.print("消费者：" + Thread.currentThread().getName() + "当前有：" + queue.size() + "个苹果，");
                        queue.take();
                        System.out.print("消费后有：" + queue.size() + "个苹果，当前时间：" + System.currentTimeMillis() + "\n");
                        if (queue.size() >= size-1) {
                            queue.notify(); // 数据达到容量的顶峰，必须消费，所以唤醒锁
                        } else if (queue.size() < 1) {
                            break;  // 如果队列长度为0，肯定不能消费了，我们退出该锁
                        } else {
                            queue.wait();   // 释放锁
                            //Thread.sleep(1000);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 不对队列加锁
    /*@Override
    public void run() {
        while (true){
            try{
                if(queue.size()>0) {
                    queue.take();
                    System.out.print("消费者："+Thread.currentThread().getName() +"当前有：" + (queue.size()+1) + "个苹果，消费后剩下：" + queue.size() + "个苹果，当前时间：" + System.currentTimeMillis() + "\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

}