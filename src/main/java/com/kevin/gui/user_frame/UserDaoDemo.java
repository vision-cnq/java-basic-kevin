package com.kevin.gui.user_frame;

/*
 *  * 问题：
 * 		接口(方法比较多) -- 实现类(仅仅使用一个，也得把其他的实现给提供了，哪怕是空实现)
 * 		太麻烦了。
 * 解决方案：
 * 		接口(方法比较多) -- 适配器类(实现接口,仅仅空实现) -- 实现类(用哪个重写哪个) 		�ӿ�(�����Ƚ϶�) -- ��������(ʵ�ֽӿ�,������ʵ��) -- ʵ����(���ĸ���д�ĸ�)
 */
public class UserDaoDemo {
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		ud.add();
		// 我没有说我们需要四种功能都实现啊。
		UserDao ud2 = new UserDaoImpl2();
		ud2.add();
	}
}
