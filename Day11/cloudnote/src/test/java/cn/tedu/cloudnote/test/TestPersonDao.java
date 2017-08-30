package cn.tedu.cloudnote.test;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.PersonDao;
import cn.tedu.cloudnote.entity.Person;
import cn.tedu.cloudnote.entity.Post;

public class TestPersonDao extends TestCaseBase {
	
	PersonDao dao;
	
	@Before
	public void initDao(){
		dao = ctx.getBean("personDao", PersonDao.class);
	}
	
	@Test
	public void testAddPerson(){
		Person p = new Person("刘老师");
		//不用为p设置ID属性!
		int n = dao.addPerson(p);
		//MyBatis会自动返回自动增加的ID
		System.out.println(p); 
	}
	
	@Test
	public void testFindPostById(){
		Post post = dao.findPostById(1);
		System.out.println(post); 
	}
}







