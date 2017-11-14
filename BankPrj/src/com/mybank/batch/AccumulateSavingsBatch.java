package com.mybank.batch;

import com.mybank.domain.Bank;
import com.mybank.domain.SavingsAccount;

public class AccumulateSavingsBatch {
	
	public void doBatch() {
		for(int i=0; i < Bank.getNumOfCustomers(); i++) {
			for(int j=0; j < Bank.getCustomer(i).getNumOfAccounts(); j++) {
				if(Bank.getCustomer(i).getAccount(j) instanceof SavingsAccount) {
					SavingsAccount account = (SavingsAccount) Bank.getCustomer(i).getAccount(j);
					account.accumulateInterest();
				}
			}
		}
		
	}
	
	

}
