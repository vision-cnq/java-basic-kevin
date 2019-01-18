package com.kevin.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/1/9
 */
public class ProducerAndConsumer {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(100);
    class Producer extends Thread {
        int i = 0;
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                i++;
                try {
                    queue.put(i);
                    System.out.println("生产者生产一条任务" + i);
                } catch (InterruptedException e) {
                    System.out.println("队列已满: " + queue.size());
                    e.printStackTrace();
                }

                /*if(!queue.offer(i)) {
                    System.out.println("队列已满: " + queue.size());
                }else {
                    System.out.println("生产者生产一条任务" + i);
                }*/
                /*try {
                    Thread.sleep(new Random().nextInt(1000)+500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());

                /*try {
                    Thread.sleep(new Random().nextInt(1000)+500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
    public static void main(String[] args) {
        ProducerAndConsumer pc = new ProducerAndConsumer();
        Producer producer = pc.new Producer();
        //Consumer consumer = pc.new Consumer();
        //Consumer consumer1 = pc.new Consumer();
        producer.start();
        for (int i = 0; i < 5; i++) {
            pc.new Consumer().start();
        }
        //consumer1.start();
    }
}
