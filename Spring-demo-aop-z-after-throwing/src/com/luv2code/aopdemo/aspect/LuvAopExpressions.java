package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	//this is where we add all of our related advices for logging
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setters() {};
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getters() {};
	
	// create point to include package and exclude getters/setters (combination)
	@Pointcut("forDaoPackage() && !(setters() || getters())")
	public void forDaoPackageOnlyMinusGetsnSets() {};
	
}
