package com.nish.Interface.Model;

public class DebitCardPayment implements Payment {
	private double amount;
	public DebitCardPayment(double amount){
		this.amount = amount;
	}
	@Override
	public void processPayment() {
		System.out.println("Debit Card Payment Successful.");
		System.out.println("Amount paid: " + amount);
	}
}
