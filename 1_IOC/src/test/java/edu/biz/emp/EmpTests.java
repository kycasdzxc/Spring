package edu.biz.emp;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.biz.getter.Emp;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/emp.xml")
public class EmpTests {
	@Setter @Inject @Qualifier("emp")
	private Emp emp;
	
	@Test
	public void testExist() {
		assertNotNull(emp);
	}
	
	@Test
	public void testWork() {
		emp.work();
	}
}
