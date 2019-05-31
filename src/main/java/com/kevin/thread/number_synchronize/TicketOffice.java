package com.kevin.thread.number_synchronize;

/**
 * @author caonanqing
 * @version 1.0
 * @description     售票处
 * @createDate 2019/5/31
 */
public class TicketOffice implements Runnable{

    // 保存线程名称
    private String name;

    // 通过构造器为线程名称赋值
    public TicketOffice(String name) {
        this.name = name;
    }

    // 获取线程名称
    public String getName() {
        return name;
    }

    // 票数
    static int tick = 50;
    // 静态钥匙，任意值
    static Object obj = "k";

    // 用线程实现买票操作
    @Override
    public void run() {
        // 判断是否有票
        while (tick > 0) {
            // 如果有票，就将锁占据
            synchronized (obj) {
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
        }

    }
}
