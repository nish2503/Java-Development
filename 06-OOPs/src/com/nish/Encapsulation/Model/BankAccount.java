package com.nish.Encapsulation.Model;

public class BankAccount {
	private final long accountNumber = 10000;
	private String accountHolder;
	private double balance;
	
	public BankAccount(String accountHolder, double initialAmount){
		this.accountHolder = accountHolder;
		this.balance = initialAmount;
		System.out.println("Account created.");
		System.out.println("Account Holder : " + accountHolder);
		System.out.println("Initial Balance : " + initialAmount);
		
	}
	
	public boolean depositMoney(double amount) {
		if(amount > 0) {
			balance += amount;
			return true;
		}
		else {
			System.out.println("Invalid deposit amount!");
			return false;
		}
	}
	
	public boolean withdrawMoney(double amount) {
		if(amount > 0) {
			if((balance - amount) >= 0) {
				balance -= amount;
				return true;
			}
			else {
				System.out.println("Insufficient balance!");
				return false;
			}
		}
		else {
			System.out.println("Invalid withdraw amount!");
			return false;
		}
	}
	
	public double getBalance() {
		return balance;
	}
}
