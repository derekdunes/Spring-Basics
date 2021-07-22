package com.luv2code.springdemo.aspect;

import java.util.List;
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

	
	//set up logger
	Logger myLogger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		//display the method we are calling
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("====> in @Before: calling method: " + method);
		
		//display the arguments to the method
		
		//get the args
		Object[] args = joinPoint.getArgs();
		
		//loop through and display the args
		for(Object tempArgs : args) {
			myLogger.info("===> argument: " + tempArgs);
		}
		
	}
	
	//Add @afterReturning advice
	@AfterReturning(pointcut="forAppFlow()", returning="res")
	public void AfterReturning(JoinPoint joinPoint, Object res) {
		
		//display the method we are calling
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("====> in @AfterReturning: calling method: " + method);
				
		//display the data returned
		myLogger.info("====> result: " + res);
		
	}
	
}
