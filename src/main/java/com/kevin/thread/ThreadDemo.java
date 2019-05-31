package com.kevin.thread;

/**
 * @author kevin
 * @version 1.0
 * @description
 *      创建线程方式一：
 *          1.创建：继承Thread+重写run
 *          2.启动：创建对象+start
 * @createDate 2019/3/7
 */
public class ThreadDemo{

    public static void main(String[] args) {

        // 创建子类对象,进入新建状态
        MyThread st1 = new MyThread();
        MyThread st2 = new MyThread();
        // 启动线程,进入就绪状态
        st1.start();
        st2.start();
        // start()之后线程并不会立刻启动，会等待CPU资源的调度

    }
}

// 继承Thread
class MyThread extends Thread {

    // 线程执行体
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " +i);
        }
    }

}
