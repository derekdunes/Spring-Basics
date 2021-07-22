package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lu2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCod;

	public List<Account> findAccounts(boolean tripWire){
		
		//for simulation
		if(tripWire) {
			throw new RuntimeException("No Soup for you!!!");
		}
		
		List<Account> accounts = new ArrayList<>();
		
		//create a sample accounts
		Account account1 = new Account("John", "Silver");
		Account account2 = new Account("Chad", "Platinium");
		Account account3 = new Account("Derek", "Gold");
		
		//add them to the list
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}
	
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCod() {
		System.out.println(getClass() + ": in getServiceCod()");
		return serviceCod;
	}

	public void setServiceCod(String serviceCod) {
		System.out.println(getClass() + ": in setServiceCod()");
		this.serviceCod = serviceCod;
	}

	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": Doing MY DB Work: Adding AN ACCOUNT");
	
	}	
	
	public boolean doWork() {
		
		System.out.println(getClass() + "Doing Work");
		
		return true;
		
	}
	
}
