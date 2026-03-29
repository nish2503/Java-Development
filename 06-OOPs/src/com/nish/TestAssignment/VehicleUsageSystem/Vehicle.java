package com.nish.TestAssignment.VehicleUsageSystem;

public abstract class Vehicle {

    private String registrationNumber;
    private String ownerName;
    private double baseCharge;

    public Vehicle(String regNo, String ownerName, double baseCharge) {

        if(baseCharge < 0)
            throw new IllegalArgumentException("Invalid charge.");

        this.registrationNumber = regNo;
        this.ownerName = ownerName;
        this.baseCharge = baseCharge;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBaseCharge() {
        return baseCharge;
    }

    public void displayDetails() {

        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Base Charge: " + baseCharge);
    }
}