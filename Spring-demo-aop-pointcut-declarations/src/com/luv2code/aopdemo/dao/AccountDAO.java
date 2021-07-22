package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.lu2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": Doing MY DB Work: Adding AN ACCOUNT");
	
	}	
	
	public boolean doWork() {
		
		System.out.println(getClass() + "Doing Work");
		
		return true;
		
	}
	
}
