package com.nish.TestAssignment.StudentEnrollmentSystem;

public class RegularStudent extends Student {

    private double tuitionFee;

    public RegularStudent(int id, String name, String course, double fee) {

        super(id, name, course);
        this.tuitionFee = fee;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Type: Regular Student");
        System.out.println("Tuition Fee: " + tuitionFee);
    }
}