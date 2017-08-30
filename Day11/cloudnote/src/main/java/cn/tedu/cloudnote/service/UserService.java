package cn.tedu.cloudnote.service;

import cn.tedu.cloudnote.entity.User;

public interface UserService {
	/*
	 * 登录功能方法
	 * @param name 用户名
	 * @param password 密码
	 */
	User login(String name,String password) 
				throws NameException,PasswordException;
	
	User regist(String name,String password,String nick)
				throws NameException,PasswordException;
}







