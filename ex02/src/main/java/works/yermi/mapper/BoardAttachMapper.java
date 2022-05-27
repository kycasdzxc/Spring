package works.yermi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import works.yermi.domain.BoardAttachVO;

public interface BoardAttachMapper {
	@Insert("INSERT INTO TBL_BOARD_ATTACH VALUES(#{uuid}, #{path}, #{origin}, #{image}, #{bno})")
	void insert(BoardAttachVO vo);
	
	@Delete("DELETE TBL_BOARD_ATTACH WHERE UUID = #{uuid}")
	void delete(String uuid);

	@Delete("DELETE TBL_BOARD_ATTACH WHERE bno = #{bno}")
	void deleteAll(Long bno);
	
	@Select("SELECT * FROM TBL_BOARD_ATTACH WHERE BNO = #{bno}")
	List<BoardAttachVO> findBy(Long bno);
	
	@Select("SELECT * FROM TBL_BOARD_ATTACH WHERE PATH = TO_CHAR(SYSDATE - 1, 'YYYY/MM/DD')")
	List<BoardAttachVO> getOldFiles();
}
