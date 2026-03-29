package com.nish.TestAssignment.StudentEnrollmentSystem;

import java.util.Scanner;

public class StudentMenu {

    public void displayMenu() {

        System.out.println("\n1. Add Regular Student");
        System.out.println("2. Add Scholarship Student");
        System.out.println("3. Display Students");
        System.out.println("4. Exit");
    }

    public void start(StudentSystem system, Scanner scanner) {

        while(true) {

            displayMenu();

            int choice = InputHelper.readPositiveInt(scanner, "Enter choice: ");

            switch(choice) {

                case 1:
                    system.addRegularStudent();
                    break;

                case 2:
                    system.addScholarshipStudent();
                    break;

                case 3:
                    system.displayStudents();
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