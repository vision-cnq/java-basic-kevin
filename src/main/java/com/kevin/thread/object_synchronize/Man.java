package com.kevin.thread.object_synchronize;

/**
 * @author caonanqing
 * @version 1.0
 * @description     男生，存款操作
 * @createDate 2019/5/31
 */
public class Man implements Runnable{

    // 创建银行对象
    private Bank bank = new Bank();

    @Override
    public void run() {
        int m = 100;
        int i = 0;
        while (i < 5) {
            // 存款
            bank.saveMoney(m);
            i++;
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
