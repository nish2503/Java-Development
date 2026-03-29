package com.nish.TestAssignment.AccountManagementSystem;

public abstract class Account {

    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accNo, String name, double balance) {

        if(balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");

        this.accountNumber = accNo;
        this.holderName = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {

        if(balance < 0)
            throw new IllegalArgumentException("Invalid balance");

        this.balance = balance;
    }

    public void displayDetails() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}