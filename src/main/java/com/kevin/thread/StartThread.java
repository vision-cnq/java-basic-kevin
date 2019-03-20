package com.kevin.thread;

/**
 * @author kevin
 * @version 1.0
 * @description
 * 创建线程方式一：
 * 1.创建：继承Thread+重写run
 * 2.启动：创建对象+start
 * @createDate 2019/3/7
 */
public class StartThread extends Thread{
    
    // 线程入口点
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边唱歌");
        }
    }

    public static void main(String[] args) {

        // 创建子类对象
        StartThread st = new StartThread();
        // 启动线程
        st.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("一边coding");
        }

    }
}
