package com.kevin.thread.deadlock;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/31
 */
public class Thread1 extends Thread {

    private DeadLock dl;

    public Thread1(DeadLock dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            System.out.println("调用rightLeft()");
            dl.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
