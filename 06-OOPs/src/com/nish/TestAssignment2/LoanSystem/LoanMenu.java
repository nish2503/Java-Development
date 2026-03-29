package com.nish.TestAssignment2.LoanSystem;

import java.util.Scanner;

public class LoanMenu {

    public void displayMenu() {

        System.out.println("\n1. Home Loan");
        System.out.println("2. Car Loan");
        System.out.println("3. Education Loan");
        System.out.println("4. Process Loans");
        System.out.println("5. Exit");
    }

    public void start(LoanSystem system, Scanner scanner) {

        while(true) {

            displayMenu();

            int choice =
                InputHelper.readPositiveInt(scanner,
                        "Enter choice: ");

            switch(choice) {

                case 1 -> system.addHomeLoan();
                case 2 -> system.addCarLoan();
                case 3 -> system.addEducationLoan();
                case 4 -> system.processLoans();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}