package com.kevin.gui.awt;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author kevin
 * @version 1.0
 * @description     限制输入类型
 * @createDate 2018/12/25
 */
public class FrameDemo7 {

    public static void main(String[] args) {
        // 创建窗体对象并设置属性
        Frame f = new Frame("不能输入非数字字符");
        f.setBounds(400, 200, 400, 300);
        f.setLayout(new FlowLayout());

        // 创建Label标签对象
        Label label = new Label("请输入你的QQ号码，不能是非数字，不信你试试");
        TextField tf = new TextField(40);

        // 添加到窗体上
        f.add(label);
        f.add(tf);

        // 设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 给文本框添加事件
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 如果你取得的字符不是数字字符就取消事件
                // 思路：先获取字符，判断字符，取消事件
                // char getKeyChar()
                char ch = e.getKeyChar();
//				System.out.println(ch);
                if(!(ch>='0' && ch<='9')){
                    e.consume();
                }
            }
        });

        // 设置窗体可见
        f.setVisible(true);
    }
}
