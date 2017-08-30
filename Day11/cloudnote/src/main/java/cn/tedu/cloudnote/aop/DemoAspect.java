package cn.tedu.cloudnote.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect : 切面
 * 切面组件类
 */
//fffffffffffffffffffffffff//<aop:aspectj-autoproxy/>
@Component //<context:component-scan 
//            base-package="cn.tedu" />
public class DemoAspect {
	
	/**
	 * 在 userService 组件的全部方法之前执行切面方法test
	 */
	@Before("bean(userService)")
	public void test(){
		System.out.println("Hello World");
	}
	 
	
	
}








