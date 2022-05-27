package edu.biz.ioc2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc2.xml");
		OrderManager manager = ctx.getBean("orderManager", OrderManager.class);
		manager.order();
		ctx.close();
	}
}
