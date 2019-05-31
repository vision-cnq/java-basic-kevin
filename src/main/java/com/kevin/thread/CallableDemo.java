package com.kevin.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 *       创建线程方式三：
 *           1.创建：实现Callable+重写call()
 *           2.启动：创建对象+start
 *  使用Callable和Future接口创建线程。具体是创建Callable接口的实现类，并实现call()方法。
 *  并使用FutureTask类来包装Callable实现类的对象，且以此FutureTask对象作为Thread对象的target来创建线程。
 * @createDate 2019/5/30
 */
public class CallableDemo {

    public static void main(String[] args) {

        // 创建MyCallable对象
        MyCallable myCallable = new MyCallable();
        // 使用FutureTask来包装MyCallable对象
        FutureTask<Integer> ft = new FutureTask<>(myCallable);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " +i);
            if(i == 30) {
                // FutureTask对象作为Thread对象的target创建新的线程
                Thread thread = new Thread(ft);
                thread.start();
            }
        }

        System.out.println("主线程for循环执行完毕...");

        // 获取新创建的线程中的call()方法返回的结果
        int sum = 0;
        try {
            sum = ft.get(); // get()方法获取子线程call()方法的返回值，当子线程没有执行完时，该方法会一直阻塞
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class MyCallable implements Callable<Integer> {

    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}
