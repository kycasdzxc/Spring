package edu.biz.ioc4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc4.xml");
		OrderManager manager = ctx.getBean("orderManager", OrderManager.class);
		manager.order();
		ctx.close();
	}
}
