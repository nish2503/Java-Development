package com.nish.TestAssignment.HospitalRecordSystem;

import java.util.Scanner;

public class InputHelper {

    public static int readPositiveInt(Scanner scanner, String prompt) {

        while(true) {

            System.out.println(prompt);

            if(scanner.hasNextInt()) {

                int value = scanner.nextInt();
                scanner.nextLine();

                if(value > 0)
                    return value;
            } 
            else {
            	scanner.nextLine();
            }

            System.out.println("Invalid input. Enter positive integer.");
        }
    }


    public static double readPositiveDouble(Scanner scanner, String prompt) {

        while(true) {

            System.out.println(prompt);

            if(scanner.hasNextDouble()) {

                double value = scanner.nextDouble();
                scanner.nextLine();

                if(value >= 0)
                    return value;
            }
            else {
            	scanner.nextLine();
            }

            System.out.println("Invalid number.");
        }
    }


    public static String readName(Scanner scanner, String prompt) {

        while(true) {

            System.out.println(prompt);

            String name = normalizeSpaces(scanner.nextLine());

            if(name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            if(!name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Only letters allowed.");
                continue;
            }

            return name;
        }
    }


    private static String normalizeSpaces(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }
}