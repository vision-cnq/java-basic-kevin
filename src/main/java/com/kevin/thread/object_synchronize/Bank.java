package com.kevin.thread.object_synchronize;

/**
 * @author caonanqing
 * @version 1.0
 * @description     钱的数量要设置成一个静态的变量。两个人要存取的同一个对象值
 * @createDate 2019/5/31
 */
public class Bank {

    // 银行卡的金额
    private static int money;

    public int getMoney() {
        return money;
    }

    // 存款
    public void saveMoney(int money) {
        // 加锁
        synchronized (this){
            System.out.println("存款后的金额: " + (this.money+=money));
        }
    }

    // 取款
    public void drawMoney(int money) {
        // 加锁
        synchronized (this) {
            Bank bank = new Bank();
            if(bank.getMoney() <= 0) {
                System.out.println("银行卡余额为0无法取款");
            } else {
                System.out.println("取款后剩余金额: " + (this.money-=money));
            }
        }
    }
}
