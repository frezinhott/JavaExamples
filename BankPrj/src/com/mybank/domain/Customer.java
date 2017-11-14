package com.mybank.domain;

import java.util.ArrayList;

public class Customer {
	private String firstName;
	private String lastName;
	private ArrayList<Account> accounts;

	public Customer(String f, String l){
		this.firstName=f;
		this.lastName=l;
		this.accounts=new ArrayList<Account>();
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public Account getAccount(int accountNum) {
		return this.accounts.get(accountNum);
	}
	
	public void addAccount(Account acc) {
		this.accounts.add(acc);
	}
	
	public int getNumOfAccounts() {
		return this.accounts.size();
	}

}
