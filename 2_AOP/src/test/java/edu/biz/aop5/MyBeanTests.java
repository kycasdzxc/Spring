package edu.biz.aop5;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/aop5.xml")
public class MyBeanTests {
	@Setter @Autowired
	private MyBean bean;
	
	@Test
	public void testExist() {
		assertNotNull(bean);
	}
	
	@Test
	public void testRun1() {
		bean.run();
	}
}
