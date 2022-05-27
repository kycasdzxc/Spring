package edu.biz.jdkproxy;

public class HelloWorldImpl implements HelloWorld{

	@Override
	public void sayHello(String msg) {
		System.out.println("Hello World :: " + msg);
	}
	
}
