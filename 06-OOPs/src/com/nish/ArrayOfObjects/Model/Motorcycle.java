package com.nish.ArrayOfObjects.Model;

public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double calculateToll() {
        return 50;
    }
}