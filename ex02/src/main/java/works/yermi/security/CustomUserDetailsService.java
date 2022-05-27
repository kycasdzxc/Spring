package works.yermi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import works.yermi.domain.CustomUser;
import works.yermi.domain.MemberVO;
import works.yermi.mapper.MemberMapper;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired @Setter
	private MemberMapper mapper;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.warn(username);
		MemberVO vo = mapper.read(username);
		return vo == null ? null : new CustomUser(vo);
	}
	
}
