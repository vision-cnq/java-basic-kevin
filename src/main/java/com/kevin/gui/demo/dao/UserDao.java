/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin.gui.demo.dao;

import com.kevin.gui.demo.pojo.User;

/**
 *
 * @author Administrator
 */
public interface UserDao {

    /**
     * 这是用户登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录是否成功
     */
    public abstract boolean login(String username, String password);

    /**
     * 这是用户注册功能
     *
     * @param user 被注册的用户信息
     */
    public abstract void regist(User user);
}
