package com.kevin.thread;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 *       创建线程方式二：
 *           1.创建：实现Runnable+重写run
 *           2.启动：创建对象+start
 *
 *     实现Runnable接口，并重写该接口的run()方法，该run()方法同样是线程执行体，
 *     创建Runnable实现类的实例，并以此实例作为Thread类的target来创建Thread对象，
 *     该Thread对象才是真正的线程对象。
 * @createDate 2019/5/30
 */
public class RunnableDemo {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 30) {
                // 创建Runnable实现类的对象
                MyRunnable myRunnable = new MyRunnable();
                // 将myRunnable作为Thread target创建新的线程
                Thread t1 = new Thread(myRunnable);
                Thread t2 = new Thread(myRunnable);
                // 调用start方法让线程进入就绪状态
                t1.start();
                t2.start();
            }
        }
    }

}

// 实现Runnable
class MyRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}