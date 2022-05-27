package edu.biz.smallMart3;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.biz.smallMart.advice.AfterRetLog;
import edu.biz.smallMart.advice.AroundLog;
import edu.biz.smallMart.advice.BeforeLog;
import edu.biz.smallMart.advice.ThrowsLog;

public class SmallMartApp3 {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("small3.xml");
		
		SmallMart mart2 = ctx.getBean("mart", SmallMart.class);
		
		try {
//			mart1.getProduct("전자제품");
//			mart1.getProduct2("식료품");
			mart2.getProduct("전자제품");
			mart2.getProduct2("식료품");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
