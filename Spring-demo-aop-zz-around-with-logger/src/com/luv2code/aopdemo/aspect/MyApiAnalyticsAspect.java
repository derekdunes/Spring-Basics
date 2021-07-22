package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageOnlyMinusGetsnSets()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Executing @Before Performing API analytics after ");
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void AfterFinallyAccountAdvice(JoinPoint jointPoint) {
		
		//Print out the method signature
		String method = jointPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @After(finally) on method " + method);
		
	}
	
}
