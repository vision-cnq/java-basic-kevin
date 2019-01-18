package com.kevin.gui.awt;

import java.awt.Frame;

/**
 * @author kevin
 * @version 1.0
 * @description     简单的awt窗体
 * @createDate 2018/12/25
 */
public class FrameDemo {
    public static void main(String[] args) {
        // 创建窗体对象
        // Frame f = new Frame();
        // Frame(String title)
        Frame f = new Frame("KEVIN");

        // 设置窗体标题
        f.setTitle("HelloWorld");
        // 设置窗体大小
        f.setSize(400, 300); // 单位：像素
        // 设置窗体位置
        f.setLocation(400, 200);

        // 调用一个方法，设置让窗体可见
        // f.show();
        f.setVisible(true);


    }
}