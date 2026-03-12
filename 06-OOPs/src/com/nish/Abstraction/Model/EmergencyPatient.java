package com.nish.Abstraction.Model;

public class EmergencyPatient extends Patient {
	private double emergencyCharges;
	
	public EmergencyPatient(String patientId, String name, double visitingCharges, double emergencyCharges, double medicineCharges) {
		super(patientId, name, visitingCharges, medicineCharges);
		this.emergencyCharges = emergencyCharges;
	}
	
	@Override
	protected double calculateCharges(){
		return visitingCharges + emergencyCharges + medicineCharges;
	}
}
