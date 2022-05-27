package edu.biz.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service @Setter @Slf4j
public class HumanApp {
	@Value("#{human.name}")
	private String name;
	@Value("#{human.age}")
	private int age;
//	@Value("#{Human}")
	@Autowired
	private Human human;
	
	public static void main(String[] args) {
		HumanApp humanApp = new ClassPathXmlApplicationContext("human.xml")
				.getBean("humanApp", HumanApp.class);
		log.info(humanApp.name);
		log.info(humanApp.age + "");
		
		log.info(humanApp.human.getName());
		log.info(humanApp.human.getAge() + "");
	}
}
