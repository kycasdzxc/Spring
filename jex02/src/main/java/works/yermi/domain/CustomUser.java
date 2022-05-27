package works.yermi.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class CustomUser extends User {
	private MemberVO member;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(MemberVO vo) {
		this(vo.getUserid(), vo.getUserpw(),
				vo.getAuths().stream().map(auth-> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList())
		);
		member = vo;
	}
	
}
