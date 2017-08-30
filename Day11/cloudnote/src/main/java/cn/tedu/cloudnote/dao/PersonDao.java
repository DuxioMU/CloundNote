package cn.tedu.cloudnote.dao;

import cn.tedu.cloudnote.entity.Person;
import cn.tedu.cloudnote.entity.Post;

public interface PersonDao {
	
	int addPerson(Person person);
	
	Post findPostById(Integer id);
}
