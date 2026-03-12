package com.nish.TestAssignment.HospitalRecordSystem;

public class Doctor extends Staff {

    private String specialization;
    private double consultationFee;

    public Doctor(int id, String name, String department, String specialization, double fee) {

        super(id, name, department);
        this.specialization = specialization;
        this.consultationFee = fee;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Specialization: " + specialization);
        System.out.println("Fee: " + consultationFee);
        System.out.println("Staff: Doctor");
    }
}