package com.nish.TestAssignment.VehicleUsageSystem;

public class Bike extends Vehicle {

    private int engineCapacity;

    public Bike(String regNo, String owner,
                double charge, int engineCapacity) {

        super(regNo, owner, charge);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Vehicle Type: Bike");
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
    }
}