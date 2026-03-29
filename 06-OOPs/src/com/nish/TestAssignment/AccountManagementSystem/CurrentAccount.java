package com.nish.TestAssignment.AccountManagementSystem;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int accNo, String name, double balance, double overdraftLimit) {

        super(accNo, name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Account Type: Current");
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}