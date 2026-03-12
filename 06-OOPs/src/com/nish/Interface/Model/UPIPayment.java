package com.nish.Interface.Model;

public class UPIPayment implements Payment {
	private double amount;
	public UPIPayment(double amount){
		this.amount = amount;
	}
	@Override
	public void processPayment() {
		System.out.println("UPI Payment Successful.");
		System.out.println("Amount paid: " + amount);
	}
}
