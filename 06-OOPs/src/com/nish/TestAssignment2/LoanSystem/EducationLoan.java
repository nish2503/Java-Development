package com.nish.TestAssignment2.LoanSystem;

public class EducationLoan extends Loan implements LoanEligibility {

    public EducationLoan(int id, String name, double principal, double rate) throws InvalidLoanException {
        super(id, name, principal, rate);
    }

    @Override
    public double calculateRepayment() {
        return principal + (principal * interestRate / 100) * 10;
    }

    @Override
    public boolean checkEligibility() {
        return principal <= 2000000;
    }
}