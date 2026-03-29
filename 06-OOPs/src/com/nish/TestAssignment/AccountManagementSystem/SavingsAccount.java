package com.nish.TestAssignment.AccountManagementSystem;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accNo, String name, double balance, double interestRate) {

        super(accNo, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate);
    }
}