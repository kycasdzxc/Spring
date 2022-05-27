package edu.biz.magic;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/magic.xml")
public class MagicianTests {
	@Setter @Inject
	private Magician magician;
	
	@Test
	public void testExist() {
		assertNotNull(magician);
	}
	
	@Test
	public void testMagic() {
		magician.magic();
	}
}
