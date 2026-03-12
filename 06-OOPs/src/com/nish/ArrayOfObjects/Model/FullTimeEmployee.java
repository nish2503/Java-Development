package com.nish.ArrayOfObjects.Model;

import com.nish.ArrayOfObjects.Model.Employee;

public class FullTimeEmployee extends Employee {
	private double basic;
	private double hra;
	private double da;
	
	public FullTimeEmployee(String name, int empId, double basic, double hra, double da){
		super(name, empId);
		this.basic = basic;
		this.hra = hra;
		this.da = da;
	}
	
	@Override
	public double calculateSalary() {
		return basic + hra + da;
	}
}
