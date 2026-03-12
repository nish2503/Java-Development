package com.nish.ArrayOfObjects.Model;

public class Truck extends Vehicle {

    private double loadWeight;

    public Truck(String vehicleNumber, double loadWeight) {
        super(vehicleNumber);
        this.loadWeight = loadWeight;
    }

    @Override
    public double calculateToll() {
        return 200 + (loadWeight * 10);
    }
}