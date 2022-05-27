package works.yermi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import works.yermi.domain.BoardVO;

public interface BoardMapper {
//	@Select("SELECT * FROM TBL_BOARD")
	public List<BoardVO> getList();
	
//	@Select("SELECT * FROM TBL_BOARD WHERE BNO = #{bno}")
	public BoardVO read(Long bno);
	
	public int insert(BoardVO vo);
	
	public int insertSelectKey(BoardVO vo);
}
