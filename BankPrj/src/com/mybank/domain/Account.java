/*
 * Account.java
 *
 * Created on November 9, 2005, 12:46 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.mybank.domain;

/**
 *
 * @author student
 */
public class Account {
    protected double balance;
    
    /** Creates a new instance of Account */
    protected Account(double initBalance) {
        balance = initBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance=balance;
    }
    
    public boolean deposit(double amt) {
        balance = balance + amt;
        return true;
    }
    
    public void withdraw(double amt) throws OverdraftException {
        if (balance >= amt) {
            balance = balance - amt;
        }
        else {
        	throw new OverdraftException("Insufficient funds. "
        			+ " Withdrawl amount: " + amt, balance-amt);        	
        }
    }
}
