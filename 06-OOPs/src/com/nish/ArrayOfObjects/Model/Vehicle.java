package com.nish.ArrayOfObjects.Model;

public class Vehicle {

    protected String vehicleNumber;

    public static int totalVehiclesProcessed = 0;
    public static double totalTollCollected = 0;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        totalVehiclesProcessed++;
    }

    public double calculateToll() {
        return 0;
    }

    public void updateTotals(double toll) {
        totalTollCollected += toll;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
    }
}