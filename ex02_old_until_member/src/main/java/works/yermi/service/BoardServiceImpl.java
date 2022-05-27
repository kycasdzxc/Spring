package works.yermi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import works.yermi.domain.BoardAttachVO;
import works.yermi.domain.BoardVO;
import works.yermi.domain.Criteria;
import works.yermi.mapper.BoardAttachMapper;
import works.yermi.mapper.BoardMapper;

@Service @AllArgsConstructor @Log4j
public class BoardServiceImpl implements BoardService {
	private BoardMapper boardMapper;
	private BoardAttachMapper boardAttachMapper;
	
	public int register(BoardVO boardVO){
		log.info("register(" + boardVO + ")"); // 공통관심사로 분류 > 하나하나 일일이 하면 귀찮 >책에 없음
		int result = boardMapper.insertSelectKey(boardVO);
		
		boardVO.getAttachs().forEach(attach -> {
			attach.setBno(boardVO.getBno());
			boardAttachMapper.insert(attach);
		});
		
		return result;
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.update(boardVO) > 0;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return boardMapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(cri);
	}
	
}
