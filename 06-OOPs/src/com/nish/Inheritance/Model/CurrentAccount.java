package com.nish.Inheritance.Model;

public class CurrentAccount extends Account {
	private double overdraftLimit;
	
	public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit){
		super(accountNumber, holderName, balance);
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	
	public void withdraw(double amount) {
		if(amount <= 0) {
			System.out.println("Invalid withdraw amount!");
			return;
		}
		if(balance - amount < -overdraftLimit) {
			System.out.println("Overdraft Limit Exceeded!");
			return;
		}
		balance -= amount;
		System.out.println("Withdrawn : " + amount);
	}
}
