package cn.tedu.cloudnote.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP 切面组件: 用于测试 业务方法的性能 
 */
@Aspect
@Component
public class TimeTestAspect {
	
	@Around("execution(* cn.tedu.cloudnote.service.UserServiceImpl.login(*,*))")
	public Object test(ProceedingJoinPoint jp)
			throws Throwable{
		long t1 = System.currentTimeMillis();
		//jp 可以获取目标业务方法的"方法签名(Signature)"
		Signature s = jp.getSignature();
		Object val = jp.proceed();//调用业务方法
		long t2 = System.currentTimeMillis();
		System.out.println(s+"耗时:"+(t2-t1)); 
		return val;
	}
}








