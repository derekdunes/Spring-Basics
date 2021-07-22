package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	// add a new advice for afterreturning
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint jointPoint, List<Account> result) {
		
		//Print out the method signature
		String method = jointPoint.getSignature().toShortString();
		System.out.println("\n===>>> Exectuning @AfterReturnin on method " + method);
		
		//print out the result of the method call
		System.out.println("\n===>>> Result is: " + result);
		
		//lets post process the data ... let's modify it
		
		//convert the all account name to uppercase
		convertAccountNametoUppercase(result);
		
		//print out the result of the method call
		System.out.println("\n===>>> Result is: " + result);
		
	}

	private void convertAccountNametoUppercase(List<Account> result) {
		
		// TODO loop through the accounts
		
		for(Account tempAccount : result){
			//convert to upperAccount
			String theUpperName = tempAccount.getName().toUpperCase();
			
			//update the acount
			tempAccount.setName(theUpperName);
		}
		
		
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exception")
	public void afterThrowingFindAccount(JoinPoint jointPoint, Throwable exception) {
		
		//Print out the method signature
		String method = jointPoint.getSignature().toShortString();
		System.out.println("\n===>>> Exectuning @AfterReturnin on method " + method);
		
		//print out the exception
		System.out.println("\n===>>> The Exception is: " + exception);
		
	}
}
