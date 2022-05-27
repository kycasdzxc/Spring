package works.yermi.webtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import works.yermi.webtest.service.BoardService;

@Controller
@RequestMapping("board")
@AllArgsConstructor
public class BoardController {
	// 서비스 인스턴스 생성
	// 서비스의 list 반환 >> request attr 바인딩
	// list.jsp 포워드
	
	private BoardService boardService;
	
	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("list", boardService.list());
	}
}