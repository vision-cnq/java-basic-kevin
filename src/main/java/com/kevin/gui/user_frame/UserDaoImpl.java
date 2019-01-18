package com.kevin.gui.user_frame;

/**
 * @author kevin
 * @version 1.0
 * @description     实现接口，需要实现接口的所有功能
 * @createDate 2018/12/25
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("添加功能");
	}

	@Override
	public void delete() {
		System.out.println("删除功能");
	}

	@Override
	public void update() {
		System.out.println("修改功能");
	}

	@Override
	public void find() {
		System.out.println("查找功能");
	}

}
