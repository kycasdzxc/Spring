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

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {
	@GetMapping("all")
    public void doAll() {
        log.info("do all can access");
    }

    @GetMapping("member")
    public void doMember() {
        log.info("member");
    }

    @GetMapping("admin")
    public void doadmin() {
        log.info("admin");
    }
}
