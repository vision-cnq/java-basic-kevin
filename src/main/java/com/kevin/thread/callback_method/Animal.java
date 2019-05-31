package com.kevin.thread.callback_method;

/**
 * @author caonanqing
 * @version 1.0
 * @description     动物类
 * @createDate 2019/5/31
 */
public abstract class Animal extends Thread{

    // 比赛距离
    public double length = 10;

    // 子类实现
    public abstract void running();

    // 将run方法在父类写，子类重写running
    @Override
    public void run() {
        super.run();
        while (length > 0) {
            running();
        }
    }

    // 在需要回调数据的地方，声明一个接口
    public interface Calltoback {
        void win();
    }

    // 创建接口对象
    public Calltoback calltoback;
}
