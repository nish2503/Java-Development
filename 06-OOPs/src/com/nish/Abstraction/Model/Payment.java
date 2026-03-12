package com.nish.Abstraction.Model;

public abstract class Payment {
	protected double amount;
	protected String paymentId;
	
	public Payment(String paymentId, double amount) {
		this.amount = amount;
		this.paymentId = paymentId;
	}
	
	public abstract double processPayment();
	
	public boolean validateAmount() {
		if(amount > 0) {
			System.out.println("Amount is valid.");
			return true;
		}
		System.out.println("Invalid amount.");
		return false;
	}
	
	public void generateReciept(double finalAmount) {
		System.out.println("Payment successful for Payment Id " + paymentId + " !");
		System.out.println("Amount to be paid : " + amount);
		System.out.println("Final Amount paid : " + finalAmount);
	}
}
