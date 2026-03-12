package com.nish.Abstraction.Model;

public class UPIPayment extends Payment{
	
	public UPIPayment(String paymentId, double amount) {
		super(paymentId, amount);
	}
	
	@Override
	public double processPayment() {
		return amount;
	}

}
