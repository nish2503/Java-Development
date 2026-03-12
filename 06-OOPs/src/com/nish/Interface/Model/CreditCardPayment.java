package com.nish.Interface.Model;

public class CreditCardPayment implements Payment {
	private double amount;
	public CreditCardPayment(double amount){
		this.amount = amount;
	}
	@Override
	public void processPayment() {
		System.out.println("Credit Card Payment Successful.");
		System.out.println("Amount paid: " + amount);
	}
}
