package com.nish.TestAssignment2.LoanSystem;

public class HomeLoan extends Loan implements LoanEligibility {

    public HomeLoan(int id, String name, double principal, double rate) throws InvalidLoanException {
        super(id, name, principal, rate);
    }

    @Override
    public double calculateRepayment() {
        return principal + (principal * interestRate / 100) * 20;
    }

    @Override
    public boolean checkEligibility() {
        return principal <= 5000000;
    }
}