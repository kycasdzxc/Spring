package works.yermi.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import works.yermi.mapper.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class SecurityTests {
	@Setter @Autowired
	private PasswordEncoder encoder;
	@Setter @Autowired
	private SampleMapper mapper;
	
	@Test
	public void testGetUsers() {
		mapper.getUsers().forEach(log::info);
	}
	
	@Test
	public void testEncode() {
		String raw = "1234";
		log.info(raw);
		String encoded = encoder.encode(raw);
		log.info(encoded);
	}
	
	@Test
	public void testUpdateUser() {
		mapper.getUsers().forEach(m->{
			String username = m.get("USERNAME");
			log.info(username);
			String password = m.get("PASSWORD");
			log.info(password);
			
			mapper.updateUser(username, encoder.encode(password));
		});
	}
}
