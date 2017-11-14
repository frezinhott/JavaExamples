package com.mybank.domain;

import java.util.ArrayList;

public class Bank {
	private static ArrayList<Customer> customers;
	
	static {
		customers = new ArrayList<Customer>();
	}
	
	public static void addCustomer(String f, String l) {
		Customer newCustomer = new Customer(f, l);
		customers.add(newCustomer);
	}
	
	public static int getNumOfCustomers() {
		return customers.size();
	}
	
	public static Customer getCustomer(int index) {
		return customers.get(index);
	}

}
