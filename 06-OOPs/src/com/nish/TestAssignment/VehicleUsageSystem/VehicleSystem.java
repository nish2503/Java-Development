package com.nish.TestAssignment.VehicleUsageSystem;

import java.util.Scanner;

public class VehicleSystem {

    private Scanner scanner = new Scanner(System.in);
    private Vehicle[] vehicles;
    private int count = 0;

    private VehicleMenu menu = new VehicleMenu();

    public VehicleSystem() {

        int size =
            InputHelper.readPositiveInt(scanner,
                    "Enter number of vehicles: ");

        vehicles = new Vehicle[size];
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void addCar() {

        String regNo =
            InputHelper.readName(scanner,
                    "Enter Registration Number: ");

        String owner =
            InputHelper.readName(scanner,
                    "Enter Owner Name: ");

        double charge =
            InputHelper.readPositiveDouble(scanner,
                    "Enter Base Charge: ");

        int seats =
            InputHelper.readPositiveInt(scanner,
                    "Enter Seating Capacity: ");

        vehicles[count++] =
            new Car(regNo, owner, charge, seats);
    }

    public void addBike() {

        String regNo =
            InputHelper.readName(scanner,
                    "Enter Registration Number: ");

        String owner =
            InputHelper.readName(scanner,
                    "Enter Owner Name: ");

        double charge =
            InputHelper.readPositiveDouble(scanner,
                    "Enter Base Charge: ");

        int engine =
            InputHelper.readPositiveInt(scanner,
                    "Enter Engine Capacity: ");

        vehicles[count++] =
            new Bike(regNo, owner, charge, engine);
    }

    public void displayVehicles() {

        if(count == 0) {
            System.out.println("No vehicles registered.");
            return;
        }

        System.out.println("\n--- Vehicle Records ---");

        for(int i = 0; i < count; i++) {

            vehicles[i].displayDetails();
            System.out.println("---------------------");
        }
    }

    public static void main(String[] args) {

        VehicleSystem system = new VehicleSystem();
        system.menu.start(system, system.scanner);
    }
}