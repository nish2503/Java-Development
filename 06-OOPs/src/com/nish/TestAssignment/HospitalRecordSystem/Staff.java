package com.nish.TestAssignment.HospitalRecordSystem;

public abstract class Staff {

    private int id;
    private String name;
    private String department;

    public Staff(int id, String name, String department) {

        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void displayDetails() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}