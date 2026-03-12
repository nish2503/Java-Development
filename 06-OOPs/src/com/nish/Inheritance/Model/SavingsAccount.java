package com.nish.Inheritance.Model;

public class SavingsAccount extends Account {
	private double minBalance = 1000;
	
	public SavingsAccount(String accountNumber, String holderName, double balance, double minBalance){
		super(accountNumber, holderName, balance);
		this.minBalance = minBalance;
	}
	
	@Override
	
	public void withdraw(double amount) {
		if(amount <= 0) {
			System.out.println("Invalid withdraw amount!");
			return;
		}
		if(balance - amount < minBalance) {
			System.out.println("Insufficient balance ! Minimum Balance of Rs. " + minBalance + " needs to be maintained.");
			return;
		}
		super.withdraw(amount);
	}
}
