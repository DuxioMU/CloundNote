package cn.tedu.cloudnote.test;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCaseBase {

	protected ClassPathXmlApplicationContext ctx;

	public TestCaseBase() {
		super();
	}

	@Before
	public void initCtx() {
		ctx=new ClassPathXmlApplicationContext(
			"conf/spring-mybatis.xml",
			"conf/spring-mvc.xml");
	}

}



