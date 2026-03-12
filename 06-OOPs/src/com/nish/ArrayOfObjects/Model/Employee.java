package com.nish.ArrayOfObjects.Model;

public class Employee {
	private int empId;
	private String name;
	public static int counter = 0;
	
	public Employee(String name, int empId) {
		this.name = name;
		this.empId = empId;
		counter++;
	}
	
	public double calculateSalary() {
		return 0;
	}
	
	public void displayDetails() {
		System.out.println("Employee ID : " + empId);
		System.out.println("Employee Name : " + name);
	}
	
	public long getEmpId() {
	    return empId;
	}

	public String getName() {
	    return name;
	}

}
