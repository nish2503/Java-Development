package com.nish.TestAssignment.VehicleUsageSystem;

public class Car extends Vehicle {

    private int seatingCapacity;

    public Car(String regNo, String owner,
               double charge, int seatingCapacity) {

        super(regNo, owner, charge);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Vehicle Type: Car");
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
}