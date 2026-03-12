package com.nish.Abstraction.Test;

import java.util.Scanner;

import com.nish.Abstraction.Model.Bus;
import com.nish.Abstraction.Model.Metro;
import com.nish.Abstraction.Model.Taxi;
import com.nish.Abstraction.Model.Transport;


public class TransportSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("------ TRANSPORT FARE SYSTEM ------");
        System.out.println("Enter number of transports:");

        int n = readValidInt(scanner);

        Transport[] transports = new Transport[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nTransport " + (i + 1));

            System.out.println("Enter Route ID (eg. RTE1234):");
            String routeId = readValidRouteId(scanner);

            System.out.println("Enter Base Fare:");
            double baseFare = readValidDouble(scanner);

            System.out.println("Select Transport Type:");
            System.out.println("1. Bus");
            System.out.println("2. Metro");
            System.out.println("3. Taxi");

            int choice = readValidChoice(scanner);

            switch (choice) {

                case 1:
                    System.out.println("Enter Distance (km):");
                    double busDistance = readValidDouble(scanner);

                    System.out.println("Enter Price per km:");
                    double busRate = readValidDouble(scanner);

                    transports[i] = new Bus(routeId, baseFare, busDistance, busRate);
                    break;

                case 2:
                    System.out.println("Enter Number of Stations:");
                    int stations = readValidInt(scanner);

                    System.out.println("Enter Price per Station:");
                    double stationRate = readValidDouble(scanner);

                    transports[i] = new Metro(routeId, baseFare, stations, stationRate);
                    break;

                case 3:
                    System.out.println("Enter Distance (km):");
                    double taxiDistance = readValidDouble(scanner);

                    System.out.println("Enter Time (minutes):");
                    double time = readValidDouble(scanner);

                    System.out.println("Enter Price per km:");
                    double taxiKmRate = readValidDouble(scanner);

                    System.out.println("Enter Price per minute:");
                    double minuteRate = readValidDouble(scanner);

                    transports[i] = new Taxi(routeId, baseFare, taxiDistance, time, taxiKmRate, minuteRate);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    i--;
            }
        }

        System.out.println("\n------ PRINTING TICKETS ------");

        for (Transport t : transports) {
        	System.out.println();
            t.printTicket();
            System.out.println();
            System.out.println("--------------------------");
        }

        scanner.close();
    }

    public static int readValidInt(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Invalid input. Enter positive integer:");
                continue;
            }

            int value = scanner.nextInt();
            scanner.nextLine();

            if (value <= 0) {
                System.out.println("Invalid. Enter positive integer:");
                continue;
            }

            return value;
        }
    }

    public static double readValidDouble(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextDouble()) {
                scanner.nextLine();
                System.out.println("Invalid input. Enter positive number:");
                continue;
            }

            double value = scanner.nextDouble();
            scanner.nextLine();

            if (value <= 0) {
                System.out.println("Invalid. Enter positive number:");
                continue;
            }

            return value;
        }
    }

    public static int readValidChoice(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Invalid input. Choose 1, 2 or 3:");
                continue;
            }

            int value = scanner.nextInt();
            scanner.nextLine();

            if (value < 1 || value > 3) {
                System.out.println("Invalid choice. Choose 1, 2 or 3:");
                continue;
            }

            return value;
        }
    }

    public static String readValidRouteId(Scanner scanner) {
        while (true) {
            String routeId = scanner.nextLine().trim();

            if (!routeId.matches("^RTE\\d{4}$")) {
                System.out.println("Invalid Route ID format. Example: RTE1234");
                continue;
            }

            return routeId;
        }
    }
}