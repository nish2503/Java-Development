package com.nish.Encapsulation.Model;

public class PremiumAccount extends BankAccount {
	static final double bonus = 1000;
	PremiumAccount(String accountHolder, double initialAmount){
		super(accountHolder, initialAmount + bonus);
		System.out.println("Premium Bonus added!");
	}
}
