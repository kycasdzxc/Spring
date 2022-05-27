package edu.biz.getter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("emp.xml");
		ctx.getBean("emp", Emp.class).work();
	}
}
 