package com.thomas.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//method points out where does the log code to be executed
	//. = classes ..=classes, methods  ..*= classes, methods and everything else
	@Pointcut("within(com.thomas.pma.controllers..*)")
	public void definePackagePointcuts() {
		//empty method just to name the location specified in the pointcut
	}
	
	//method with the code to be run at the pointcut
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		log.debug(" \n \n \n ");
		log.debug("********** Before Method Execution ********** \n{}. {} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("_____________________________________________\n \n \n");
		
		Object o = null;
		
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.debug(" \n \n \n ");
		log.debug("********** Before Method Execution ********** \n{}. {} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("_____________________________________________\n \n \n");
		
		return o;
		
	}
}
