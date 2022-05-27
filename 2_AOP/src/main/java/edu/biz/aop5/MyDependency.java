package edu.biz.aop5;

import org.springframework.stereotype.Service;

@Service
public class MyDependency {
	public void hello(int intValue) {
		System.out.println("hello :: " + intValue);
	}
	public void goodbye() {
		System.out.println("goodbye");
	}
}
