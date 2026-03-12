package com.nish.ArrayOfObjects.Model;

public class Car extends Vehicle {

    private boolean isCommercial;

    public Car(String vehicleNumber, boolean isCommercial) {
        super(vehicleNumber);
        this.isCommercial = isCommercial;
    }

    @Override
    public double calculateToll() {
        return isCommercial ? 150 : 100;
    }
}