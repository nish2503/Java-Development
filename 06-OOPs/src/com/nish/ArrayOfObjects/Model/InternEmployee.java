package com.nish.ArrayOfObjects.Model;

import com.nish.ArrayOfObjects.Model.Employee;

public class InternEmployee extends Employee {

    private double fixedAmount;
    private double tax;

    public InternEmployee(String name, int empId, double fixedAmount, double tax) {
        super(name, empId);
        this.fixedAmount = fixedAmount;
        this.tax = tax;
    }

    @Override
    public double calculateSalary() {
        return fixedAmount - tax;
    }
}
