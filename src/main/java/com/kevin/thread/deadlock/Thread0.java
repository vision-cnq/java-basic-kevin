package com.kevin.thread.deadlock;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/31
 */
public class Thread0 extends Thread {
    private DeadLock dl;

    public Thread0(DeadLock dl) {
        this.dl = dl;
    }

    @Override
    public void run() {
        try {
            System.out.println("调用leftRight()");
            dl.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}