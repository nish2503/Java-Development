package com.nish.project.util;

import java.util.Scanner;

import com.nish.project.service.StudentService;

public class InputHelper {

    public static int readInt(Scanner scanner, String prompt) {

        while(true) {

            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();

                if(value > 0) return value;

                System.out.println("Enter positive number.");

            } catch(Exception e) {

                System.out.println("Invalid integer.");
                scanner.nextLine();
            }
        }
    }


    public static double readDouble(Scanner scanner, String prompt) {

        while(true) {

            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();

                if(value >= 0) return value;

                System.out.println("Enter positive value.");

            } catch(Exception e) {

                System.out.println("Invalid number.");
                scanner.nextLine();
            }
        }
    }


    public static String readString(Scanner sc, String prompt) {

        while(true) {
            System.out.print(prompt);

            String name =
                sc.nextLine().trim().replaceAll("\\s+", " ");

            if(name.isEmpty()) {
                System.out.println("Cannot be empty.");
                continue;
            }
            
            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name. Only alphabets allowed.");
                continue;
            }
            
            return name;
        }
    }
    
    public static int readExistingStudentId(Scanner scanner, StudentService service) {
        while (true) {
            int id = InputHelper.readInt(scanner, "Enter Student ID: ");

            if (service.studentExists(id)) {
                return id; 
            }

            System.out.println("Student not found. Please re-enter.");
        }
    }
    
    public static int readNewStudentId(Scanner scanner, StudentService service) {
        while (true) {
            int id = InputHelper.readInt(scanner, "Enter Student ID: ");

            if (service.studentExists(id)) {
                System.out.println("Student ID already exists. Try a different ID.");
            } else {
                return id;
            }
        }
    }
}