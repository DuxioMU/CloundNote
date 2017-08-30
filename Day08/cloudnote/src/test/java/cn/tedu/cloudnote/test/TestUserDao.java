package cn.tedu.cloudnote.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.User;

public class TestUserDao {
	//@Test
	public void testFindByName(){
		ApplicationContext ctx
				=new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao
				=ctx.getBean("userDao", UserDao.class);
		
		User user
				=dao.findByName("demo");
		
		System.out.println(user);
	}
	@Test
	public void testAddUser(){
		ApplicationContext ctx
				= new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao
				=ctx.getBean("userDao", UserDao.class);
		User user
			=new User("1","liqing","123456","","mangseng");
		dao.addUser(user);
	}
}







