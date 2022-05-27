package works.yermi.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component @Aspect @Log4j
public class LogAdvice {
	@Before("within(works.yermi.service.*) or within(works.yermi.controller.*)")
	public void beforeLog(JoinPoint jp) {
		log.info(String.format("%s %s(%s)%n",
				jp.getSignature().getDeclaringType().getSimpleName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs())
				));
	}
}
