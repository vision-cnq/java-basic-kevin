package com.kevin.queue;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/1/9
 */
public class QueueTest {

    public static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Producer("Producer1"));

        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer("Consumer"+i));
        }
        service.shutdown();
    }

    static class Producer implements Runnable {
        private final String name;

        int i = 0;

        Producer(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            while (true) {
                i++;
                if(!queue.offer("Product" + i)) {
                    System.out.println("队列满: "+queue.size());
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("生产数据: "+queue.size());

                }
            }

        }
    }

    static class Consumer implements Runnable {
        private final String name;
        private static Random rand = new Random(System.currentTimeMillis());

        Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true){
                    System.out.println("消费数据: " + queue.size());
                    String str = queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
