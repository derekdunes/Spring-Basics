package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		
		System.out.println(getClass() + "Doing Stuff: adding a Membership Account");
		
		return true;
		
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": I 'm going to sleep now....");
		
	}
	
}
