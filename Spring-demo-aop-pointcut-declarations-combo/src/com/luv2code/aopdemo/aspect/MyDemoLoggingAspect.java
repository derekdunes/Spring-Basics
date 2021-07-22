package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advices for logging
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setters() {};
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getters() {};
	
	// create point to include package and exclude getters/setters (combination)
	@Pointcut("(forDaoPackage() || setters()) && !getters())")
	private void forDaoPackageOnlyMinusGetsnSets() {};
	
	//let's start with an @Before Advice
	//@Before("execution(public void add*())")
	@Before("forDaoPackageOnlyMinusGetsnSets()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
		
	}
	
	@After("forDaoPackageOnlyMinusGetsnSets()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Executing @After Performing API analytics after ");
	}
}
