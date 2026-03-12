package com.nish.Abstraction.Model;

public class WalletPayment extends Payment{
	
	public double processingFeeRate = 0.01;
	public double processedFee = 0;
	
	public WalletPayment(String paymentId, double amount) {
		super(paymentId, amount);
	}
	
	@Override
	public double processPayment() {
		this.processedFee = processingFeeRate*amount;
		return (amount + processedFee);
	}
	
	@Override
	public void generateReciept(double amount) {
		super.generateReciept(amount);
		System.out.println("Processed Fee Amount : " + processedFee);
	}
}
