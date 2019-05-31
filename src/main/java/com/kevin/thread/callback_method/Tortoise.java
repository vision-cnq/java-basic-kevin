package com.kevin.thread.callback_method;

/**
 * @author caonanqing
 * @version 1.0
 * @description     乌龟类
 * @createDate 2019/5/31
 */
public class Tortoise extends Animal {

    public Tortoise() {
        setName("乌龟");// Thread的方法，给线程赋值名字
    }

    // 重写running方法，编写乌龟的奔跑操作
    @Override
    public void running() {
        // 跑的距离
        double dis = 0.1;
        length -= dis;
        System.out.print("乌龟跑了" + dis + "米");
        if (length <= 0) {
            length = 0;
            System.out.println("，乌龟获得了胜利");
            // 让兔子不要在跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }else {
            System.out.println("，距离终点还有" + String.format("%.2f",length) + "米");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
