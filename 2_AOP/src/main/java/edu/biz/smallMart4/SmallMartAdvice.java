package edu.biz.smallMart4;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component @Aspect
public class SmallMartAdvice {
	@Before("execution(* *2(String))")
	public void smallBefore(JoinPoint jp) {
		System.out.println("사전" + ":" + jp.getSignature().getName());
	}
	
	public void adv() {
		System.out.println("사전2");
	}
	
	public void logging(JoinPoint jp) {
		System.out.printf("[%s.%s(%s) :: %s] - ",
				jp.getTarget().getClass().getName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()),
				new SimpleDateFormat("yyyy-MM-dd hh:mma"));
	}
}