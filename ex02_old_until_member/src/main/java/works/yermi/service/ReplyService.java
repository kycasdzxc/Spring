package works.yermi.service;

import java.util.List;

import works.yermi.domain.CriteriaReply;
import works.yermi.domain.ReplyVO;

public interface ReplyService {
	int register(ReplyVO vo);
	
	ReplyVO get(Long rno);
	
	int modify(ReplyVO vo);
	
	int remove(Long rno);
	
	List<ReplyVO> getList(Long bno, CriteriaReply cri);
}
