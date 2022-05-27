package edu.biz.jdbc2;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("fifile:src/main/resources/jdbc2.xml")
@Slf4j
public class EmpDaoTests {
	@Setter @Autowired
	private EmpDao dao;
	
	@Test
	public void testExist() {
		assertNotNull(dao);
		log.info(dao.toString());
	}
}
