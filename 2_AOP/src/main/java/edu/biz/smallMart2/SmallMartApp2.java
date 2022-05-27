package edu.biz.smallMart2;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import edu.biz.smallMart.advice.AfterRetLog;
import edu.biz.smallMart.advice.AroundLog;
import edu.biz.smallMart.advice.BeforeLog;
import edu.biz.smallMart.advice.ThrowsLog;

public class SmallMartApp2 {
	public static void main(String[] args) throws Exception {
		SmallMart mart1 = new SmallMartImpl();
		
		System.err.println("===================");
		ProxyFactory pf = new ProxyFactory();

		AspectJExpressionPointcut apc = new AspectJExpressionPointcut();
		apc.setExpression("execution(* *2(..))");
		
		pf.addAdvisor(new DefaultPointcutAdvisor(apc, new BeforeLog()));
		pf.setTarget(mart1);
		
		SmallMart mart2 = (SmallMart) pf.getProxy();
		try {
			mart2.getProduct("전자제품");
			mart2.getProduct2("식료품");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
