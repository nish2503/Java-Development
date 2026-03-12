package com.nish.Abstraction.Model;

public class OutPatient extends Patient {
	
	public OutPatient(String patientId, String name, double visitingCharges, double medicineCharges) {
		super(patientId, name, visitingCharges, medicineCharges);
	}
	
	@Override
	protected double calculateCharges(){
		return visitingCharges + medicineCharges;
	}
}
