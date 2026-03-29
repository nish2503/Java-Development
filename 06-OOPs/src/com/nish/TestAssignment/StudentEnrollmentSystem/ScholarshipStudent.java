package com.nish.TestAssignment.StudentEnrollmentSystem;

public class ScholarshipStudent extends Student {

    private double scholarshipAmount;

    public ScholarshipStudent(int id, String name,
                              String course, double scholarship) {

        super(id, name, course);
        this.scholarshipAmount = scholarship;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Type: Scholarship Student");
        System.out.println("Scholarship: " + scholarshipAmount);
    }
}