package com.kevin.gui.awt;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author kevin
 * @version 1.0
 * @description     一级菜单
 * @createDate 2018/12/25
 */
public class FrameDemo8 {
    public static void main(String[] args) {
        // 创建窗体对象并设置属性
        Frame f = new Frame("一级菜单");
        f.setBounds(400, 200, 400, 300);
        f.setLayout(new FlowLayout());

        // 创建菜单栏
        MenuBar mb = new MenuBar();
        // 创建菜单
        Menu m = new Menu("文件");
        // 创建菜单项
        MenuItem mi = new MenuItem("退出系统");

        // 谁添加谁呢
        m.add(mi);
        mb.add(m);

        // 设置菜单栏
        f.setMenuBar(mb);

        // 设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 设置窗体可见
        f.setVisible(true);
    }
}