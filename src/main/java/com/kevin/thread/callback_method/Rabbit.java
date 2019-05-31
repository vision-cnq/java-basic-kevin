package com.kevin.thread.callback_method;

/**
 * @author caonanqing
 * @version 1.0
 * @description     兔子类
 * @createDate 2019/5/31
 */
public class Rabbit extends Animal {

    public Rabbit(){
        setName("兔子");  // 为线程名称赋值
    }

    // 重写running方法，编写兔子的奔跑操作
    @Override
    public void running() {

        // 跑的距离
        double dis = 0.5;
        length -= dis;
        System.out.print("兔子跑了" + dis + "米");
        if (length <= 0) {
            // 跑完后距离减少
            length = 0;
            System.out.println("，兔子获得了胜利");
            // 给回调对象赋值
            if(calltoback != null)
                calltoback.win();
        } else {
            System.out.println("，距离终点还有" + String.format("%.2f",length) + "米");
            if (length % 2 == 0) {  // 两米休息一秒
                try {
                    sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
