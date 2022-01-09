package com.anurag.springdemo.aspect;

import java.util.Iterator;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger

	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setUp pointcut declaration
	@Pointcut("execution(* com.anurag.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	// do the same for service and DAO
	@Pointcut("execution(* com.anurag.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.anurag.springdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void appFlow() {
	}

	// @Before advice
	@Before("appFlow()")
	public void beforeAdvice(JoinPoint thJoinPoint) {

		// display the AOP advice test
		myLogger.info("\n\nBefore advice of AOP in the picture ===>>>>>>>>>>");

		// displaying the method signature
		String signature = thJoinPoint.getSignature().toString();
		myLogger.info("Method signature is: " + signature);

		// display the argument
		Object[] args = thJoinPoint.getArgs();

		// get the argument
		for (Object object : args) {
			myLogger.info("====>>>>>> Arguments are: " + object);
		}
	}

	// Add @AfterReturning
	@AfterReturning(pointcut = "appFlow()", returning = "theResult")
	public void afterReturn(JoinPoint theJoinPoint, Object theResult) {

		// display the AOP advice test
		myLogger.info("\n\nAfter return advice of AOP in the picture ===>>>>>>>>>>");

		// displaying the method signature
		String signature = theJoinPoint.getSignature().toString();
		myLogger.info("Method signature is: " + signature);
		
		//display the data result
		myLogger.info("The returned data are: "+theResult);
	}

}

























