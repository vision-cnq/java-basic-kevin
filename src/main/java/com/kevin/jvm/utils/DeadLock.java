package com.kevin.jvm.utils;

/**
 * @author caonanqing
 * @version 1.0
 * @description     线程死锁监控
 * @createDate 2019/7/19
 */
public class DeadLock implements Runnable {

    private Object obj1;
    private Object obj2;

    public DeadLock(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized(obj1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println("Hello World...");
            }
        }
    }


}
