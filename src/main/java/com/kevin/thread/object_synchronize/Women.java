package com.kevin.thread.object_synchronize;

/**
 * @author caonanqing
 * @version 1.0
 * @description     女生，取款操作
 * @createDate 2019/5/31
 */
public class Women implements Runnable {

    // 创建银行对象
    private Bank bank = new Bank();

    @Override
    public void run() {
        int m = 100;
        int i=0;
        while (i<5) {
            // 取款
            bank.drawMoney(m);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
