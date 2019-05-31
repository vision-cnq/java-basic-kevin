package com.kevin.thread.callback_method;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/31
 */
public class LetOneStop implements Animal.Calltoback {
    // 动物对象
    Animal an;

    // 获取动物对象，可以传入兔子或乌龟的实例
    public LetOneStop(Animal an) {
        this.an = an;
    }

    //让动物的线程停止
    @Override
    public void win() {
        // 线程停止
        an.stop();
        //an.interrupt();
    }
}
