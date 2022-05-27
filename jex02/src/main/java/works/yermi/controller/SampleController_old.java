package works.yermi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

import works.yermi.domain.SampleVO;
import works.yermi.domain.Ticket;

@RestController
//@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController_old {
	@GetMapping(value="getText", produces="text/plain; charset=utf-8")
	// @ResponseBody
	public String getText() {
		log.info(MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	@GetMapping("getSample")
	public SampleVO getSample(){
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping("getMap")
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("mno", 112);
		map.put("firstName", "스타");
		map.put("lastName", "로드");
		return map;
	}
	
	@GetMapping("getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"First", i+"last")).collect(Collectors.toList());
	}
	
	@GetMapping("check")
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0, height+"", weight+"");
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}
		else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping("product/{category}/{pid}")
	public String[] getPath(@PathVariable("category") String cat, @PathVariable(required=false) Optional<Integer> pid) {
		return new String[] {"category: " + cat, "productId: " + pid.get()};
	}
	
	@PostMapping("ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert :: " + ticket);
		return ticket;
	}
}
