package works.yermi.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import works.yermi.config.RootConfig;
import works.yermi.domain.BoardVO;
import works.yermi.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
@Log4j
public class BoardMapperTests {
	@Setter @Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testExist(){
		assertNotNull(boardMapper);
	}
	
	@Test
	public void testGetList(){ // 전체목록
		Criteria criteria = new Criteria();
		
		List<BoardVO> result = boardMapper.getList(criteria);
		assertNotNull(result);
		result.forEach(log::info);
	}
	@Test
	public void testGetListWithPaging(){ // 전체목록
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(10);
//		cri.setType("TW");
//		cri.setKeyword("12");
		log.info(cri);
		
		List<BoardVO> result = boardMapper.getListWithPaging(cri);
		assertNotNull(result);
		result.forEach(log::info);
	}
	@Test
	public void testRead(){ // 선택목록
		BoardVO result = boardMapper.read(11115L);
		assertNotNull(result);
		log.info(result);
	}
	@Test
	public void testInsert(){ // 글 삽입
		
		// init
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("mapper test title");
		boardVO.setContent("mapper test content");
		boardVO.setWriter("user00");
		log.info(boardVO);
		
		// expect
		int exp = 1;
		
		// result
		int result = boardMapper.insert(boardVO);
		
		assertEquals("게시글 추가", exp, result);
	}
	@Test
	public void testInsertSelectKey(){ // 글 삽입
		
		// init
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("mapper test title selectKey");
		boardVO.setContent("mapper test content selectKey");
		boardVO.setWriter("user00");
		log.info(boardVO);
		
		// expect
		int exp = 1;
		
		// result
		int result = boardMapper.insertSelectKey(boardVO);
		
		assertEquals("게시글 추가", exp, result);
	}
	@Test
	public void testUpdate(){ 
		
		// init
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test update");
		boardVO.setContent("test update");
		boardVO.setBno(11115L);
		log.info(boardVO);
		
		// expect
		int exp = 1;
		
		// result
		int result = boardMapper.update(boardVO);
		
		assertEquals("게시글 수정", exp, result);
		log.info(boardVO);
	}
	@Test
	public void testDelete(){ 
		
		// init
		Long bno = 11115L;
		log.info(bno);
		
		// expect
		int exp = 1;
		
		// result
		int result = boardMapper.delete(bno);
		
		assertEquals("게시글 삭제", exp, result); // 결과확인
	}
	
	@Test
	public void testGetTotalCount(){
		Criteria cri = new Criteria();
		cri.setPageNum(4);
		cri.setAmount(3);
		cri.setType("T");
		cri.setKeyword("1234");
		log.info(boardMapper.getTotalCount(cri));
	}
	
	@Test
	public void testGetListDynamicTest(){
		Criteria cri = new Criteria();
		cri.setType("TC"); // 제목 + 내용
		log.info(Arrays.toString(cri.getTypeArr()));
		cri.setKeyword("테스트");
		boardMapper.getListDynamicTest(cri);
	}
	
	@Test
	public void testStringJoin(){
		String[] arr = {"1", "2", "3", "4", "5"};
		log.info(String.join("", arr));
	}
	
}
