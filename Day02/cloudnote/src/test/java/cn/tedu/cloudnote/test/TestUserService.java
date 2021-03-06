package cn.tedu.cloudnote.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.service.UserService;

public class TestUserService {
	private UserService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext ctx
			=new ClassPathXmlApplicationContext(conf);
		service=ctx.getBean(
						"userService", UserService.class);
	}
	//@Test //用例-1,预期:用户名错误
	public void test1(){
		User user=
				service.Login("zhangsan", "123");
	}
	//@Test //用例-2,预期:密码错误
	public void test2(){
		User user=
				service.Login("demo", "123");
	}
	@Test //用例-3,预期:登录成功
	public void test3(){
		User user
				=service.Login("demo", "123456");
		System.out.println(user);
	}
}















