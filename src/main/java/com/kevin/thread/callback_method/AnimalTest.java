package com.kevin.thread.callback_method;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 *
 *  龟兔赛跑：20米
 *
 *  要求：
 *      1.兔子每秒0.5米的速度，每跑2米休息10秒，
 *      2.乌龟每秒跑0.1米，不休息
 *      3.其中一个跑到终点后另一个不跑了！
 *
 *  思路：
 *      1.创建一个Animal动物类，继承Thread，编写一个running抽象方法，重写run方法，把running方法在run方法里面调用。
 *      2.创建Rabbit兔子类和Tortoise乌龟类，继承动物类
 *      3.两个子类重写running方法
 *      4.在动物类创建一个回调接口，创建一个回调对象
 *
 * @createDate 2019/5/31
 */
public class AnimalTest {

    /**
     * 龟兔赛跑：20米
     * */
    public static void main(String[] args) {
        //实例化乌龟和兔子
        Tortoise tortoise = new Tortoise();
        Rabbit rabbit = new Rabbit();
        //回调方法的使用，谁先调用calltoback方法，另一个就不跑了
        LetOneStop letOneStop1 = new LetOneStop(tortoise);
        rabbit.calltoback = letOneStop1;//让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
        LetOneStop letOneStop2 = new LetOneStop(rabbit);
        tortoise.calltoback = letOneStop2;//让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
        //开始跑
        tortoise.start();
        rabbit.start();

    }
}
