package edu.biz.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HelloWorldHandler implements InvocationHandler {
	private Object target;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("전처리");
//		System.out.println(args[0]);
		Object obj = method.invoke(target, args);
		System.out.println("후처리");
		return obj;
	}
}
