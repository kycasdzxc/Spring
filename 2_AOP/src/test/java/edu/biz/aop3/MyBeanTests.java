package edu.biz.aop3;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/aop3.xml")
public class MyBeanTests {
	@Setter @Autowired @Qualifier("myBean1")
	private MyBean bean1;
	@Setter @Autowired @Qualifier("myBean2")
	private MyBean bean2;
	
	@Test
	public void testExist() {
		assertNotNull(bean1);
		assertNotNull(bean2);
	}
	
	@Test
	public void testRun1() {
		bean1.run();
	}
	@Test
	public void testRun2() {
		bean2.run();
	}
}
