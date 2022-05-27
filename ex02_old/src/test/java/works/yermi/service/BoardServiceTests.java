package works.yermi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

import works.yermi.domain.BoardVO;
import works.yermi.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter @Autowired
	private BoardService boardService;
	
	@Test
	public void testExist(){
		assertNotNull(boardService);
	}
	
	@Test
	public void testGet(){ // 전체목록
		Criteria criteria = new Criteria();
		
		List<BoardVO> result = boardService.getList(criteria);
		assertNotNull(result);
		result.forEach(log::info);
	}
	@Test
	public void testGetList(){ // 전체목록
		Criteria criteria = new Criteria();
		
		List<BoardVO> result = boardService.getList(criteria);
		assertNotNull(result);
		result.forEach(log::info);
	}
	@Test
	public void testRegister(){ // 글 삽입
		
		// init
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("service test title2323");
		boardVO.setContent("service test content2323");
		boardVO.setWriter("user01");
		log.info(boardVO);
		
		// expect
		int exp = 1;
		
		// result
		int result = boardService.register(boardVO);
		
		assertEquals("게시글 추가", exp, result);
	}
	@Test
	public void testModify(){ 
		
		// init
		BoardVO boardVO = boardService.get(26L);
		log.info(boardVO);
		boardVO.setTitle("service test modify1414");
		log.info(boardVO);
		
		// expect
		boolean exp = true;
		
		// result
		boolean result = boardService.modify(boardVO);
		
		assertEquals("게시글 수정", exp, result);
		log.info(boardVO);
	}
	@Test
	public void testDelete(){ 
		
		// init
		Long bno = 26L;
		log.info(bno);
		
		// expect
		boolean exp = true;
		
		// result
		boolean result = boardService.remove(bno);
		
		assertEquals("게시글 수정", exp, result); // 결과확인
	}
	@Test
	public void testGetTotalCount(){
		log.info(boardService.getTotalCount(new Criteria()));
	}
}
