package com.mybank.domain;

public class SavingsAccount extends Account{
	private double interestRate;
	
	public SavingsAccount(double initBalance, double interestRate){
		super(initBalance);
		this.setInterestRate(interestRate);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void accumulateInterest() {
		super.setBalance(super.balance + (super.balance * (this.getInterestRate()/12)));
	}

}
