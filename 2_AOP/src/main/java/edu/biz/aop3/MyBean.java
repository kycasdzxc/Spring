package edu.biz.aop3;

import lombok.Setter;

public class MyBean {
	@Setter
	private MyDependency dependency;
	
	public void run() {
		dependency.hello();
		dependency.goodbye();
	}
}
