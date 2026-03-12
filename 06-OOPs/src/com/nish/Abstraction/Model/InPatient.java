package com.nish.Abstraction.Model;

public class InPatient extends Patient {
	private double roomCharges;
	
	public InPatient(String patientId, String name, double visitingCharges, double roomCharges, double medicineCharges) {
		super(patientId, name, visitingCharges, medicineCharges);
		this.roomCharges = roomCharges;
	}
	
	@Override
	protected double calculateCharges(){
		return visitingCharges + roomCharges + medicineCharges;
	}
}
