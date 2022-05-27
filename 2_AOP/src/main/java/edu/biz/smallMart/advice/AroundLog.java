package edu.biz.smallMart.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLog implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("어라운드 사전");
		Object obj = invocation.proceed();
		System.out.println("어라운드 사후");
		return null;
	}
	
}
