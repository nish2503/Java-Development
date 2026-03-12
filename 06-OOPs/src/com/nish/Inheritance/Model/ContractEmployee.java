package com.nish.Inheritance.Model;

public class ContractEmployee extends Employee {

    private double fixedAmount;
    private double tax;

    public ContractEmployee(String name, int empId, double fixedAmount, double tax) {
        super(name, empId);
        this.fixedAmount = fixedAmount;
        this.tax = tax;
    }

    @Override
    public double calculateSalary() {
        return fixedAmount - tax;
    }
}
