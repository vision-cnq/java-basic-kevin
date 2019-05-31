package com.kevin.thread.object_synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author caonanqing
 * @version 1.0
 * @description     银行存取钱问题
 * @createDate 2019/5/31
 */
public class BankTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        // 存款线程有3个
        for (int i = 0; i < 3; i++) {
            service.execute(new Man());
        }
        // 取款线程有3个
        for (int i = 0; i < 3; i++) {
            service.execute(new Women());
        }
    }
}
