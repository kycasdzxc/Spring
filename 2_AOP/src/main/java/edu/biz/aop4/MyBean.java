package edu.biz.aop4;

import lombok.Setter;

public class MyBean {
	@Setter
	private MyDependency dependency;
	
	public void run() {
		dependency.hello(6000);
		dependency.hello(4000);
		dependency.goodbye();
	}
}
