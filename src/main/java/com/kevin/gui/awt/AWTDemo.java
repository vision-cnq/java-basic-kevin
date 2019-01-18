package com.kevin.gui.awt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author kevin
 * @version 1.0
 * @description     awt监听鼠标
 * @createDate 2018/12/25
 */
public class AWTDemo extends Frame{ //继承自Frame

	String keystr="";    //记录键盘事件
	String mousestr="";  //记录鼠标事件
	int mouseX=0;   //x坐标
	int mouseY=0;   //y坐标

	public AWTDemo(){

		//添加事件处理机制
		this.addKeyListener(new MyKeyAdapter(this));
		this.addMouseListener(new MyMouseAdapter(this));
		this.addWindowListener(new MyWindowAdapter());
	}

	//显示界面内容的方法
	public void paint(Graphics g){

		g.drawString(keystr,10,50);
		g.drawString(mousestr,mouseX,mouseY);
	}

	public static void main(String [] args){

		AWTDemo d=new AWTDemo();
		d.setTitle("AWT小程序");
		d.setSize(500,300);
		d.setVisible(true);
	}

}

//创建键盘监听器，继承自KeyAdapter
class MyKeyAdapter extends KeyAdapter{
	AWTDemo demo;

	public MyKeyAdapter(AWTDemo demo){
		this.demo=demo;

	}
}

//创建鼠标事件的监听器
class MyMouseAdapter extends MouseAdapter{
	AWTDemo demo;
	public MyMouseAdapter(AWTDemo demo){
		this.demo=demo;

	}
	//鼠标单击时触发的事件
	public void mousePressed(MouseEvent me){
		demo.mouseX=me.getX();
		demo.mouseY=me.getY();
		demo.mousestr="当前坐标："+demo.mouseX+","+demo.mouseY;
		demo.repaint();
	}
}

//添加窗体关闭监听器
class MyWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent we){
		System.exit(0);
	}
}

