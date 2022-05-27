package edu.biz.aop5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class MyBean {
	@Setter @Autowired
	private MyDependency dependency;
	
	public void run() {
		dependency.hello(6000);
		dependency.hello(4000);
		dependency.goodbye();
	}
}
