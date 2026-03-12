package com.nish.TestAssignment.HospitalRecordSystem;

public class Nurse extends Staff {

    private String shift;
    private int ward;

    public Nurse(int id, String name, String dept, String shift, int ward) {

        super(id, name, dept);
        this.shift = shift;
        this.ward = ward;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Shift: " + shift);
        System.out.println("Ward: " + ward);
        System.out.println("Staff: Nurse");
    }
}