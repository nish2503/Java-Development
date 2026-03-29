package com.nish.TestAssignment2.LoanSystem;

import java.util.Scanner;

public class LoanSystem {

    private static String systemConfig;

    static {
        systemConfig = "Loan System Initialized";
        System.out.println(systemConfig);
    }

    private Scanner scanner = new Scanner(System.in);
    private Loan[] loans = new Loan[10];
    private int count = 0;

    private LoanMenu menu = new LoanMenu();

    public void addHomeLoan() {

        try {

            int id = InputHelper.readPositiveInt(scanner,"Loan ID: ");
            String name = InputHelper.readName(scanner,"Borrower Name: ");
            double amount = InputHelper.readPositiveDouble(scanner,"Amount: ");
            double rate = InputHelper.readPositiveDouble(scanner,"Interest Rate: ");

            loans[count++] = new HomeLoan(id,name,amount,rate);

        } catch(InvalidLoanException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addCarLoan() {

        try {

            int id = InputHelper.readPositiveInt(scanner,"Loan ID: ");
            String name = InputHelper.readName(scanner,"Borrower Name: ");
            double amount = InputHelper.readPositiveDouble(scanner,"Amount: ");
            double rate = InputHelper.readPositiveDouble(scanner,"Interest Rate: ");

            loans[count++] = new CarLoan(id,name,amount,rate);

        } catch(InvalidLoanException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addEducationLoan() {

        try {

            int id = InputHelper.readPositiveInt(scanner,"Loan ID: ");
            String name = InputHelper.readName(scanner,"Borrower Name: ");
            double amount = InputHelper.readPositiveDouble(scanner,"Amount: ");
            double rate = InputHelper.readPositiveDouble(scanner,"Interest Rate: ");

            loans[count++] = new EducationLoan(id,name,amount,rate);

        } catch(InvalidLoanException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public void processLoans() {

        for(int i = 0; i < count; i++) {
        	System.out.println("\n--- Loans Record ---");
            Loan loan = loans[i];
            System.out.println();
            loan.displayLoanInfo();

            if(((LoanEligibility)loan).checkEligibility()) {

                System.out.println("Eligible");
                System.out.println("Repayment: " +
                        loan.calculateRepayment());
            }
            else
                System.out.println("Not Eligible");

            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {

        LoanSystem system = new LoanSystem();
        system.menu.start(system, system.scanner);
    }
}