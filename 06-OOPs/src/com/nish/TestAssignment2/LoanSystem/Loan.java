package com.nish.TestAssignment2.LoanSystem;

public abstract class Loan {

    protected int loanId;
    protected String borrowerName;
    protected double principal;
    protected double interestRate;

    public Loan(int loanId, String borrowerName, double principal, double interestRate) throws InvalidLoanException {

        if(principal <= 0)
            throw new InvalidLoanException("Invalid loan amount");

        if(interestRate <= 0)
            throw new InvalidLoanException("Invalid interest rate");

        this.loanId = loanId;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.interestRate = interestRate;
    }

    public void displayLoanInfo() {

        System.out.println("Loan ID: " + loanId);
        System.out.println("Borrower: " + borrowerName);
        System.out.println("Principal: " + principal);
        System.out.println("Interest Rate: " + interestRate);
    }

    public abstract double calculateRepayment();
}