package works.yermi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import works.yermi.domain.BoardVO;
import works.yermi.domain.Criteria;
import works.yermi.domain.pageDTO;
import works.yermi.service.BoardService;

@Controller
@RequestMapping("board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("list")
	public String list(Model model, Criteria cri) {
		model.addAttribute("boards", boardService.getList(cri));
		model.addAttribute("page", new pageDTO(boardService.getTotalCount(cri), cri));
		return "/board/list";
	}
	
	@GetMapping("list2") @ResponseBody // json문자열 형태 반환
	public List<BoardVO> list(Criteria cri){
		return boardService.getList(cri);
	}
	
	@GetMapping("register")
	public void register(@ModelAttribute("cri") Criteria cri){
		
	}
	
	@PostMapping("register")
	public String register(BoardVO boardVO, RedirectAttributes rttr, Criteria cri){
		boardService.register(boardVO);
		rttr.addFlashAttribute("result", boardVO.getBno());
		rttr.addAttribute("pageNum", 1);
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
	}
	
	@GetMapping({"get", "modify"})
	public void get(Long bno, Criteria cri, Model model) {
		model.addAttribute("boards", boardService.get(bno));
		model.addAttribute("cri", cri);
	}
	
	@PostMapping("modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr, Criteria cri){
		log.info(cri);
		if(boardService.modify(boardVO)){
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list" + cri.getParams();
	}
	
	@PostMapping("remove")
	public String remove(Long bno, RedirectAttributes rttr, Criteria cri){
		log.info(cri);
		if(boardService.remove(bno)){
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
