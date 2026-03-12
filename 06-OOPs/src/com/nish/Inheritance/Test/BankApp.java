package com.nish.Inheritance.Test;

import java.util.Scanner;

import com.nish.Inheritance.Model.Account;
import com.nish.Inheritance.Model.CurrentAccount;
import com.nish.Inheritance.Model.SavingsAccount;

public class BankApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("Select Account Type:");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
            	scanner.next();
                System.out.println("Invalid input.\n");
                continue;
            }

            choice = scanner.nextInt();

            if (choice == 1 || choice == 2)
                break;

            System.out.println("Invalid choice.\n");
        }

        scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();

        String name = readValidName(scanner, "Enter Holder Name : ");

        double balance = readPositiveDouble(scanner, "Enter Initial Balance: ");

        Account account;

        switch (choice) {
            case 1:
                double minBalance = readPositiveDouble(scanner, "Enter Minimum Balance: ");
                account = new SavingsAccount(accNo, name, balance, minBalance);
                break;

            case 2:
                double overdraft = readPositiveDouble(scanner, "Enter Overdraft Limit: ");
                account = new CurrentAccount(accNo, name, balance, overdraft);
                break;

            default:
            	scanner.close();
                return;
        }

        while (true) {

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Details");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            if (!scanner.hasNextInt()) {
            	scanner.next();
                System.out.println("Invalid input.");
                continue;
            }

            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    account.deposit(readPositiveDouble(scanner, "Enter deposit amount: "));
                    continue;

                case 2:
                    account.withdraw(readPositiveDouble(scanner, "Enter withdrawal amount: "));
                    continue;

                case 3:
                    account.displayDetails();
                    continue;

                case 4:
                	System.out.println("Thanks for visiting!");
                	scanner.close();
                    return;
            }

            System.out.println("Invalid option.");
        }
    }

    private static double readPositiveDouble(Scanner scanner, String message) {

        while (true) {
            System.out.print(message);

            if (!scanner.hasNextDouble()) {
            	scanner.next();
                System.out.println("Invalid input.");
                continue;
            }

            double value = scanner.nextDouble();

            if (value < 0) {
                System.out.println("Value cannot be negative.");
                continue;
            }

            return value;
        }
    }
    
    private static String readValidName(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String name = scanner.nextLine().trim();
            name = name.replaceAll("\\s+", " ");

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            if (!name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
                System.out.println("Invalid input. Only alphabets allowed.");
                continue;
            }

            return name;
        }
    }

}
