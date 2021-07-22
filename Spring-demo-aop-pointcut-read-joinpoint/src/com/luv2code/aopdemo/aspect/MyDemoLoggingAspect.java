package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lu2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//let's start with an @Before Advice
	//@Before("execution(public void add*())")
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageOnlyMinusGetsnSets()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
		
		//display mathid signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		//display method arguments
		
		//get args
		Object[] args = joinPoint.getArgs();
		
		//loop through args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				//Downcast and print Account specific
				Account account = (Account) tempArg;
				
				System.out.println("Account name: " + account.getName());
				System.out.println("Account Level: " + account.getLevel());
				
			}
		}
	}
	
}
