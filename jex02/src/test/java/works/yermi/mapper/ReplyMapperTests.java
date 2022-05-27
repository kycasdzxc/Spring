package works.yermi.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.stream.IntStream;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import works.yermi.domain.CriteriaReply;
import works.yermi.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	@Autowired @Setter
	private ReplyMapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
		log.info(mapper);
	}
//	12605
//	12604
//	12603
//	12602
//	12589
	@Test
	public void testInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(12605L);
		vo.setReply("댓글내용");
		vo.setReplyer("작성자");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testCreate() {
		Long[] bnoArr = {376925L, 376925L, 376925L, 376925L, 376925L};
		IntStream.rangeClosed(1, 100).forEach(r ->{
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[r%5]);
			vo.setReply("댓글 내용" + r);
			vo.setReplyer("작성자" + r);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		ReplyVO replyVO = mapper.read(8L);
		log.info(replyVO);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(25L);
	}
	
	@Test
	public void testUpdate() {
		ReplyVO replyVO = mapper.read(1L);
		replyVO.setReply("수정된 내용");
		
		mapper.update(replyVO);
	}
	
	@Test
	public void testList() {
		mapper.getListWithPaging(12605L, new CriteriaReply());
	}
}
