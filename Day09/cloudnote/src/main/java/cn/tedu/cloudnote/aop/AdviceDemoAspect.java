package cn.tedu.cloudnote.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class AdviceDemoAspect {
	
	@Before("bean(userService)")
	public void t1(){
		System.out.println("Before");
	}
	@AfterReturning("bean(userService)")
	public void t2(){
		System.out.println("AfterReturning");
	}
	@AfterThrowing("bean(userService)")
	public void t3(){
		System.out.println("AfterThrowing");
	}
	@After("bean(userService)")
	public void t4(){
		System.out.println("After");
	}

}
