package com.nish.TestAssignment.VehicleUsageSystem;

import java.util.Scanner;

public class VehicleMenu {

    public void displayMenu() {

        System.out.println("\n1. Register Car");
        System.out.println("2. Register Bike");
        System.out.println("3. Display Vehicles");
        System.out.println("4. Exit");
    }

    public void start(VehicleSystem system, Scanner scanner) {

        while(true) {

            displayMenu();

            int choice =
                InputHelper.readPositiveInt(scanner,
                        "Enter choice: ");

            switch(choice) {

                case 1:
                    system.addCar();
                    break;

                case 2:
                    system.addBike();
                    break;

                case 3:
                    system.displayVehicles();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}