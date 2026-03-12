package com.nish.Inheritance.Model;

public class Account {
	protected String accountNumber;
	protected String holderName;
	protected double balance;
	
	Account(String accountNumber, String holderName, double balance){
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Invalid deposit amount!");
			return;
		}
		balance += amount;
		System.out.println("Deposited : " + amount);
	}
	
	public void withdraw(double amount) {
		if(amount <= 0) {
			System.out.println("Invalid withdraw amount!");
			return;
		}
		if(amount > balance) {
			System.out.println("Insufficient balance!");
			return;
		}
		balance -= amount;
		System.out.println("Withdrawn : " + amount);
	}
	
	public void displayDetails() {
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Account Holder Name : " + holderName);
		System.out.println("Current Balance : " + balance);
	}
}
