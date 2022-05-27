package edu.biz.aop1;

// target
public /*final*/ class Hello implements HelloInter{
	
	// join point
	public /*final*/ void sayHello() {
		System.out.println("안녕");
	}
}
