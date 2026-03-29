package com.nish.TestAssignment.AccountManagementSystem;

import java.util.Scanner;

public class BankSystem {

    private Scanner scanner = new Scanner(System.in);
    private Account[] accounts;
    private int count = 0;

    private BankMenu menu = new BankMenu();

    public BankSystem() {

        int size = InputHelper.readPositiveInt(scanner, "Enter number of accounts: ");
        accounts = new Account[size];
    }

    public Scanner getScanner() {
        return scanner;
    }


    public void addSavingsAccount() {

        int accNo = InputHelper.readPositiveInt(scanner, "Enter Account Number: ");
        String name = InputHelper.readName(scanner, "Enter Holder Name: ");
        double balance = InputHelper.readPositiveDouble(scanner, "Enter Balance: ");
        double rate = InputHelper.readPositiveDouble(scanner, "Enter Interest Rate: ");
        accounts[count++] = new SavingsAccount(accNo, name, balance, rate);
    }


    public void addCurrentAccount() {

        int accNo = InputHelper.readPositiveInt(scanner, "Enter Account Number: ");
        String name = InputHelper.readName(scanner, "Enter Holder Name: ");
        double balance = InputHelper.readPositiveDouble(scanner, "Enter Balance: ");
        double limit = InputHelper.readPositiveDouble(scanner, "Enter Overdraft Limit: ");
        accounts[count++] = new CurrentAccount(accNo, name, balance, limit);
    }


    public void displayAccounts() {

        if(count == 0) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("\n--- Account Details ---");

        for(int i = 0; i < count; i++) {

            accounts[i].displayDetails();
            System.out.println("--------------------");
        }
    }


    public static void main(String[] args) {

        BankSystem system = new BankSystem();
        system.menu.start(system, system.scanner);
    }
}