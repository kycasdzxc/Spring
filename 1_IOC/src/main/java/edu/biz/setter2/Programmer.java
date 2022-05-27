package edu.biz.setter2;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j @Repository
public class Programmer implements Emp {

	@Override
	public void gotoOffice() {
		log.info("프로그래머 출근합니다.");
	}

	@Override
	public void GetOffWork() {
		log.info("프로그래머 퇴근합니다.");
	}
	
}
