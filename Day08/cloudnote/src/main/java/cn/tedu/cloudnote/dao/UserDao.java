package cn.tedu.cloudnote.dao;

import cn.tedu.cloudnote.entity.User;

public interface UserDao {
	User findByName(String name);
	
	void addUser(User user);
	
	User findUserById(String userId);
}
