package edu.biz.constructor1;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor @Slf4j
public class Develope {
	private Emp emp;
	
	void coding() {
		emp.gotoOffice();
		log.info("개발합니다...");
		emp.GetOffWork();
	}
}
