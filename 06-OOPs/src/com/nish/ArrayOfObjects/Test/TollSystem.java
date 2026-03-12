package com.nish.ArrayOfObjects.Test;

import java.util.Scanner;
import com.nish.ArrayOfObjects.Model.*;

public class TollSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("------ WELCOME TO TOLL MANAGEMENT SYSTEM ------");
        System.out.println("Enter number of vehicles: ");
        int n = readValidInt(scanner);

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nVehicle " + (i + 1));

            System.out.println("Enter Vehicle Number: ");
            String vehicleNumber = readValidVehicleNumber(scanner);

            System.out.println("Select Vehicle Type:");
            System.out.println("1. Car");
            System.out.println("2. Truck");
            System.out.println("3. Motorcycle");

            int choice = readValidChoice(scanner);

            switch (choice) {

                case 1:
                    System.out.println("Is Commercial? (true/false): ");
                    boolean isCommercial = readValidBoolean(scanner);
                    vehicles[i] = new Car(vehicleNumber, isCommercial);
                    break;

                case 2:
                    System.out.println("Enter Load Weight: ");
                    double weight = readValidDouble(scanner);
                    vehicles[i] = new Truck(vehicleNumber, weight);
                    break;

                case 3:
                    vehicles[i] = new Motorcycle(vehicleNumber);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    i--;
            }
        }

        System.out.println("\n------ TOLL SUMMARY ------");

        for (Vehicle v : vehicles) {
            v.displayDetails();
            double toll = v.calculateToll();   // Polymorphism
            v.updateTotals(toll);
            System.out.println("Toll: " + toll);
            System.out.println("--------------------------");
        }

        System.out.println("Total Vehicles Processed: " + Vehicle.totalVehiclesProcessed);
        System.out.println("Total Toll Collected: " + Vehicle.totalTollCollected);

        scanner.close();
    }

    // ---------------- VALIDATION METHODS ----------------

    public static int readValidInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Enter positive number: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter again: ");
            }
        }
    }

    public static int readValidChoice(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < 1 || value > 3) {
                    System.out.println("Invalid. Choose 1, 2 or 3: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter again: ");
            }
        }
    }

    public static double readValidDouble(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("Enter positive value: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter again: ");
            }
        }
    }

    public static boolean readValidBoolean(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Enter true or false: ");
        }
    }

    public static String readValidVehicleNumber(Scanner scanner) {
        while (true) {
            String number = scanner.nextLine().trim();
            if (number.isEmpty()) {
                System.out.println("Vehicle number cannot be empty. Enter again: ");
                continue;
            }
            return number;
        }
    }
}