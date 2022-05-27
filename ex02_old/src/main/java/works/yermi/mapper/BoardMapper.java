package works.yermi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import works.yermi.domain.BoardVO;
import works.yermi.domain.Criteria;

public interface BoardMapper { // dao 역할 대신
//	@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0") <!-- BoardMapper.xml에 @select 어노테이션 대행 -->
	public List<BoardVO> getList(Criteria criteria);

	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public BoardVO read(Long bno);
	
	// DML 문장들은 반환타입 int로 하는거 추천 > 몇개 나왔는지 확인위해
//	@Insert("INSERT INTO TBL_BOARD(BNO, TITLE, CONTENT, WRITER) "
//			+ "VALUES (SEQ_BOARD.NEXTVAL, #{TITLE}), #{CONTENT}), #{WRITER})")
	public int insert(BoardVO boardVO);

	public int insertSelectKey(BoardVO boardVO);
	
	public int delete(Long bno);
	
	public int update(BoardVO boardVO);

	public int getTotalCount(Criteria cri);
	
	public List<BoardVO> getListDynamicTest(Criteria cri);
}
