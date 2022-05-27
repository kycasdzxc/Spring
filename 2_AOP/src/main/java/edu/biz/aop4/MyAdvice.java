package edu.biz.aop4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void simpleBefore(JoinPoint joinPoint, int intValue) {
		if(intValue > 5000) {
			System.out.println("advice 적용");
		}
	}
	public Object simpleAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around");
		return pjp.proceed();
	}
	
	public void simpleAfter(JoinPoint joinPoint) {
		System.out.println("after");
	}
}
