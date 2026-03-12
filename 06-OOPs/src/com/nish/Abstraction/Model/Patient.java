package com.nish.Abstraction.Model;

public abstract class Patient {
	private String patientId;
	private String name;
	protected double visitingCharges;
	protected double medicineCharges;
	
	Patient(String patientId, String name, double visitingCharges, double medicineCharges){
		this.patientId = patientId;
		this.name = name;
		this.visitingCharges = visitingCharges;
		this.medicineCharges = medicineCharges;
	}
	
	protected abstract double calculateCharges();
	
	protected double getTax(double amount) {
		return amount*0.05;
	}
	
	public void generateBill() {
		
		double baseAmount = calculateCharges();
		double taxAmount = getTax(baseAmount);
		double finalAmount = baseAmount + taxAmount;
		
		System.out.println("Patient ID: " + patientId);
		System.out.println("Patient Name: " + name);
		System.out.println("Base Amount: " + baseAmount);
		System.out.println("Tax Amount (5%): " + taxAmount);
		System.out.println("Final Amount :" + finalAmount);
	}

}
