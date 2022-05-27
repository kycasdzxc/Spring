package edu.biz.getter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Emp {
	public abstract Emp getEmp();
	public void work() {
		log.info(this.getClass().getSimpleName() + "가 일을 합니다.");
	}
}
