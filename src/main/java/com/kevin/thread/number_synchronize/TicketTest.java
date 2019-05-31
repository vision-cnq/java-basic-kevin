package com.kevin.thread.number_synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author caonanqing
 * @version 1.0
 * @description     对同一个数量进行操作
 *      多个售票处同时出售50张票
 *      1.票数需要是静态值，被共享
 *      2.避免出售同一张票，需要加同步锁
 *
 * @createDate 2019/5/31
 */
public class TicketTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        // 三个售票处同时出售50张票
        for (int i = 0; i < 3; i++) {
            service.execute(new TicketOffice("售票处"+i));
        }
    }
}
