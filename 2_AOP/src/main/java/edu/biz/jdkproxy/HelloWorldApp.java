package edu.biz.jdkproxy;

import java.lang.reflect.Proxy;

public class HelloWorldApp {
	public static void main(String[] args) {
		HelloWorld helloWorld1 = new HelloWorldImpl();
		helloWorld1.sayHello("원본객체");
		
		System.out.println("=======================");
		HelloWorld helloWorld2 = (HelloWorld) Proxy.newProxyInstance(
				HelloWorld.class.getClassLoader(), new Class[] {HelloWorld.class}, new HelloWorldHandler(helloWorld1));
		helloWorld2.sayHello("대리객체");
		
		System.out.println("=======================");
		System.out.println(helloWorld1);
		System.out.println(helloWorld2);
	}
}
