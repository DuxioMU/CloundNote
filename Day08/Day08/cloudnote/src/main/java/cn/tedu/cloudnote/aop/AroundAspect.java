package cn.tedu.cloudnote.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {

	//环绕通知
	//使用环绕通知的方法必须包含如下:
	//1. 必须包含方法参数 ProceedingJoinPoint
	//2. 必须有返回值 Object
	//3. 必须抛出异常 Throwable
	@Around("bean(userService)")
	public Object testAround(ProceedingJoinPoint jp)
		throws Throwable{
		try{
			//@Before
			//在业务方法之前增加了逻辑功能
			System.out.println("Hello Around"); 
			//调用了目标业务方法
			Object val = jp.proceed();
			//返回业务方法的返回值
			//@AfterReturning
			return val;
		}catch(Throwable e){
			throw e;
			//@AfterThrowing
		}finally{
			//@After
		}
	}
}
