package com.nish.ArrayOfObjects.Model;

import com.nish.ArrayOfObjects.Model.Employee;

public class PartTimeEmployee extends Employee {

    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int empId, double hoursWorked, double hourlyRate) {
        super(name, empId);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

