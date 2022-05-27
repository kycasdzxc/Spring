package works.yermi.mapper;

import works.yermi.domain.AuthVO;
import works.yermi.domain.MemberVO;

public interface MemberMapper {
	MemberVO read(String userid);
	
	int insertMember(MemberVO vo);
	
	int insertAuth(AuthVO vo);
}
