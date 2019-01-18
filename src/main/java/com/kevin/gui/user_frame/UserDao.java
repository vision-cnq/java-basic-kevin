package com.kevin.gui.user_frame;

/**
 * @author kevin
 * @version 1.0
 * @description     针对用户操作的四种功能接口
 * @createDate 2018/12/25
 */
public interface UserDao {
	public abstract void add();

	public abstract void delete();

	public abstract void update();

	public abstract void find();
}
