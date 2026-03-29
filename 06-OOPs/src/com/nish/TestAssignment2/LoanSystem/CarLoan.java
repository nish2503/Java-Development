package com.nish.TestAssignment2.LoanSystem;

public class CarLoan extends Loan implements LoanEligibility {

    public CarLoan(int id, String name, double principal, double rate) throws InvalidLoanException {
        super(id, name, principal, rate);
    }

    @Override
    public double calculateRepayment() {
        return principal + (principal * interestRate / 100) * 5;
    }

    @Override
    public boolean checkEligibility() {
        return principal <= 1000000;
    }
}