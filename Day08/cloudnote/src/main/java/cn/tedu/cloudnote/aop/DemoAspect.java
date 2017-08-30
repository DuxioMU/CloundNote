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
@Aspect //<aop:aspectj-autoproxy/>
@Component //<context:component-scan 
//            base-package="cn.tedu" />
public class DemoAspect {
	
	/**
	 * 在 userService 组件的全部方法之前执行切面方法test
	 */
	//@After("bean(userService)")
	public void test(){
		System.out.println("Hello World");
	}
	
	//@Before("bean(userService)")
	public void t1(){
		System.out.println("Before");
	}
	//@AfterReturning("bean(userService)")
	public void t2(){
		System.out.println("AfterReturning");
	}
	//@AfterThrowing("bean(userService)")
	public void t3(){
		System.out.println("AfterThrowing");
	}
	//@After("bean(userService)")
	public void t4(){
		System.out.println("After");
	}
	
	//环绕通知
	//使用环绕通知的方法必须包含如下:
	//1. 必须包含方法参数 ProceedingJoinPoint
	//2. 必须有返回值 Object
	//3. 必须抛出异常 Throwable
	@Around("bean(userService)")
	public Object testAround(ProceedingJoinPoint jp)
		throws Throwable{
		//在业务方法之前增加了逻辑功能
		System.out.println("Hello Around"); 
		//调用了目标业务方法
		Object val = jp.proceed();
		//返回业务方法的返回值
		return val;
	}
	
	
	
	
	
}








