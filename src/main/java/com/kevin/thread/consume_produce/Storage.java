package com.kevin.thread.consume_produce;

import java.util.LinkedList;

/**
 * @author caonanqing
 * @version 1.0
 * @description     生产者与消费者
 *      wait、notify、notifyAll实现
 *   1.wait()使当前线程阻塞，前提是 必须先获得锁，一般配合synchronized 关键字使用，即，一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
 *   2.wait() 需要被try catch包围，中断也可以使wait等待的线程唤醒。
 *   3.notify/notifyAll()的执行只是唤醒沉睡的线程，而不会立即释放锁，会等代码执行完才会释放锁
 *   4.notify 和wait 的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的
 * @createDate 2019/5/31
 */
public class Storage implements AbstractStorage{

    // 仓库最大容量
    private final int MAX_SIZE = 100;
    // 仓库存储的载体
    private LinkedList list = new LinkedList();

    // 生产者
    @Override
    public void produce(int num) {
        // 同步list数据
        synchronized(list) {
            // 仓库剩余的容量不足以存放即将要生产的数量，暂停生产
            while (list.size() + num > MAX_SIZE) {
                System.out.println("要生产的产品数量: " + num + "\t" + "库存量: " + list.size() + "\t暂时不能生产产品");

                try {
                    // 仓库容量不足，将锁释放，让消费者去消费
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 仓库有足够的容量支持本次生产，继续生产
            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            System.out.println("已经生产产品数: " + num + "\t仓库库存为: " + list.size());
            // 唤醒线程
            list.notifyAll();
        }
    }

    // 消费者
    @Override
    public void consume(int num) {

        // 同步list数据
        synchronized (list) {
            // 要消费的产品量大于仓库库存，不满足消费条件
            while (num > list.size()) {
                System.out.println("要消费的产品数量: " + num + "\t库存量: " + list.size() + "\t暂时不能执行消费任务");

                try {
                    // 仓库产品不足，将锁释放，让生产者去生产
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 仓库有足够的产品支持本次消费，继续消费
            for (int i = 0; i < num; i++) {
                list.remove();
            }
            System.out.println("已经消费产品数: " + num + "\t现仓储量为: " + list.size());
            // 唤醒线程
            list.notifyAll();
        }

    }

}
