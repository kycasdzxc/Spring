package works.yermi.webtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import works.yermi.webtest.dao.BoardDao;
import works.yermi.webtest.domain.Board;

@Service @AllArgsConstructor
public class BoardService {
	private BoardDao dao;
	
	public List<Board> list() {
		return dao.list();
	}
}