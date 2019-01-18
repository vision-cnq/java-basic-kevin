package com.kevin.gui.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author kevin
 * @version 1.0
 * @description     窗体关闭案例
 * @createDate 2018/12/25
 */
public class FrameDemo3 {

    public static void main(String[] args) {
        // 创建窗体对象
        Frame f = new Frame("窗体关闭案例");

        // 设置窗体属性
        f.setBounds(400, 200, 400, 300);

        // 让窗体关闭
        //事件源
        //事件：对窗体的处理
        //事件处理：关闭窗口(System.exit(0));
        //事件监听
//		f.addWindowListener(new WindowListener() {
//			@Override
//			public void windowOpened(WindowEvent e) {
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//			}
//		});

        //用适配器类改进
        f.addWindowListener(new WindowAdapter() {
            // 关闭窗体
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 设置窗体可见
        f.setVisible(true);
    }
}
