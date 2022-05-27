package edu.biz.setter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor @Service
public class DevelopeApp {
	@Autowired
	static Develope develope;
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("setter1.xml")
			.getBean("develope", Develope.class).coding();
	}
}
