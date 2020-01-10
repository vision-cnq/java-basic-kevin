package com.kevin.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试对比HashMap、Hashtable、ConcurrentHasMap安全性
 * @createDate 2020/1/9
 */
public class ConcurrentHashMapTest {

    static HashMap<Integer,Integer> hashMap = new HashMap<>();
    static Hashtable<Integer,Integer> hashTable = new Hashtable<>();
    static ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        int count = 1000000;
        Thread t1 = new Thread(new ThreadConcurrentHashMap(count));
        Thread t2 = new Thread(new ThreadConcurrentHashMap(count));
        Thread t3 = new Thread(new ThreadConcurrentHashMap(count));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("HashMap线程结束之后的长度：" + hashMap.size());
        System.out.println("hashTable线程结束之后的长度：" + hashTable.size());
        System.out.println("concurrentHashMap线程结束之后的长度：" + concurrentHashMap.size());

    }

}

class ThreadConcurrentHashMap implements Runnable {

    int count;
    public ThreadConcurrentHashMap(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            ConcurrentHashMapTest.hashMap.put(i,i);
            ConcurrentHashMapTest.hashTable.put(i,i);
            ConcurrentHashMapTest.concurrentHashMap.put(i,i);
        }
    }
}