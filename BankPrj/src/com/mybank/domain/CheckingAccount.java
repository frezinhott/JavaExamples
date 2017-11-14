package com.mybank.domain;

public class CheckingAccount extends Account{
	private double overdraftAmount;
	
	public CheckingAccount(double initBalance, double overdraft) {
		super(initBalance);
		this.setOverdraftAmount(overdraft);
	}
	
	public CheckingAccount(double initBalance) {
		this(initBalance,0);
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
	
	public void withdraw(double amt) throws OverdraftException{
		if(super.getBalance() - amt < 0) {
			if(super.getBalance() - amt + this.overdraftAmount > 0) {
				this.setOverdraftAmount(super.getBalance() - amt + this.overdraftAmount);
				super.setBalance(0);
			}
			else {
				throw new OverdraftException("Insufficient funds for overdraft protection. " 
					+ " Withdrawl amount: " + amt, super.getBalance() + this.overdraftAmount - amt); 
			}
		}
		else {
			super.setBalance(super.getBalance() - amt);
		}
			
	}
}
