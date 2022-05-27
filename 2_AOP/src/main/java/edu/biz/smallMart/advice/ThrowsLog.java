package edu.biz.smallMart.advice;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsLog implements ThrowsAdvice{
	public void afterThrowing(Throwable throwable) {
		System.out.println("에러발생");
	}
}
