package edu.biz.setter1;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter @Slf4j
public class Develope {
	private Emp emp;
	
	void coding() {
		emp.gotoOffice();
		log.info("개발합니다...");
		emp.GetOffWork();
	}
}
