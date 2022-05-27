package works.yermi.service;

import java.util.List;

import works.yermi.domain.BoardAttachVO;
import works.yermi.domain.BoardVO;
import works.yermi.domain.Criteria;

public interface BoardService {
	int register(BoardVO boardVO);
	
	BoardVO get(Long bno); // 접근제어자 있든없든 public 으로 동작
	// 인터페이스의 메서드는 기본으로 public속성을 가지고 있다 > 자바의 정석 1장

	boolean modify(BoardVO boardVO);
	
	boolean remove(Long bno);
	
	List<BoardVO> getList(Criteria cri);

	int getTotalCount(Criteria cri);
	
	List<BoardAttachVO> getAttachs(Long bno);
}
