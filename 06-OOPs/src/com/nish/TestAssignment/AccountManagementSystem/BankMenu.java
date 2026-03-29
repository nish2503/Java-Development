package com.nish.TestAssignment.AccountManagementSystem;

import java.util.Scanner;

public class BankMenu {

    public void displayMenu() {

        System.out.println("\n1. Add Savings Account");
        System.out.println("2. Add Current Account");
        System.out.println("3. Display Accounts");
        System.out.println("4. Exit");
    }

    public void start(BankSystem system, Scanner scanner) {

        while(true) {

            displayMenu();

            int choice = InputHelper.readPositiveInt(scanner, "Enter choice: ");

            switch(choice) {

                case 1:
                    system.addSavingsAccount();
                    break;
                case 2:
                    system.addCurrentAccount();
                    break;
                case 3:
                    system.displayAccounts();
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