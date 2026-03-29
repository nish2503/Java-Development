package com.nish.TestAssignment.ProductInventorySystem;

import java.util.Scanner;

public class InputHelper {

    public static int readPositiveInt(Scanner sc, String prompt) {

        while(true) {

            try {

                System.out.print(prompt);
                int value = sc.nextInt();
                sc.nextLine();

                if(value > 0)
                    return value;

                System.out.println("Enter positive number.");

            } catch(Exception e) {

                System.out.println("Invalid integer.");
                sc.nextLine();
            }
        }
    }


    public static double readPositiveDouble(Scanner sc, String prompt) {

        while(true) {

            try {

                System.out.print(prompt);
                double value = sc.nextDouble();
                sc.nextLine();

                if(value >= 0)
                    return value;

                System.out.println("Invalid price.");

            } catch(Exception e) {

                System.out.println("Invalid number.");
                sc.nextLine();
            }
        }
    }


    public static String readName(Scanner sc, String prompt) {

        while(true) {

            System.out.print(prompt);

            String name =
                sc.nextLine().trim().replaceAll("\\s+", " ");

            if(name.isEmpty()) {
                System.out.println("Cannot be empty.");
                continue;
            }

            return name;
        }
    }
}