package com.nish.ArrayOfObjects.Test;

import java.util.Scanner;

import com.nish.ArrayOfObjects.Model.Course;
import com.nish.ArrayOfObjects.Model.Employee;
import com.nish.ArrayOfObjects.Model.FullTimeEmployee;
import com.nish.ArrayOfObjects.Model.PartTimeEmployee;
import com.nish.ArrayOfObjects.Model.InternEmployee;

public class PayrollSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("------WELCOME TO PAYROLL APP------");
		System.out.println("Enter number of employees: ");
		int n = readValidInt(scanner);
		scanner.nextLine();

		Employee[] employees = new Employee[n];

		for (int i = 0; i < n; i++) {
			System.out.println("\nEmployee " + (i + 1) + ":");
			System.out.println("Enter Employee ID (only digits): ");
			int empId = readValidId(scanner);
			System.out.println("Enter Employee Name: ");
			String name = readValidName(scanner);

			System.out.println("Select Employee Type:");
			System.out.println("1. Full Time");
			System.out.println("2. Part Time");
			System.out.println("3. Intern");

			int choice = readValidChoice(scanner);

			switch (choice) {

			case 1:
				System.out.println("Enter basic: ");
				double basic = readValidDouble(scanner);
				System.out.println("Enter hra: ");
				double hra = readValidDouble(scanner);
				System.out.println("Enter da: ");
				double da = readValidDouble(scanner);
				scanner.nextLine();
				employees[i] = new FullTimeEmployee(name, empId, basic, hra, da);
				break;

			case 2:
				System.out.println("Enter hours worked: ");
				double hoursWorked = readValidDouble(scanner);
				System.out.println("Enter hourly rate: ");
				double hourlyRate = readValidDouble(scanner);
				scanner.nextLine();
				employees[i] = new PartTimeEmployee(name, empId, hoursWorked, hourlyRate);
				break;

			case 3:
				System.out.println("Enter fixed amount: ");
				double fixedAmount = readValidDouble(scanner);
				System.out.println("Enter tax: ");
				double tax = readValidDouble(scanner);
				scanner.nextLine();
				employees[i] = new InternEmployee(name, empId, fixedAmount, tax);
				break;
				
			default :
				System.out.println("Invalid choice. Enter again:");
				break;
			}	
			
		}
		
		System.out.println("\n--- Payroll ---");

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("Salary: " + employee.calculateSalary());
            System.out.println("-------------------------");
        }
        

		System.out.println("Total Employees: " + Employee.counter);
		System.out.println("---------------------------");

        scanner.close();
	}

	public static int readValidInt(Scanner scanner) {
		while (true) {
			if (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			int value = scanner.nextInt();

			if (value <= 0) {
				System.out.println("Invalid value. Enter positive number: ");
				continue;
			}

			return value;
		}
	}

	public static int readValidId(Scanner scanner) {
		while (true) {

			String empId = scanner.nextLine().trim();

			if (!empId.matches("^\\d+$")) {
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			return Integer.parseInt(empId);
		}
	}

	public static String readValidName(Scanner scanner) {
		while (true) {

			String name = scanner.nextLine().trim();
			
			name = name.replaceAll("\\s+", " ");

			if (name.isEmpty()) {
				System.out.println("Name cannot be empty. Enter again: ");
				continue;
			}

			if (!name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			return name;
		}
	}

	public static int readValidChoice(Scanner scanner) {
		while (true) {
			if (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			int value = scanner.nextInt();

			if (value < 1 || value > 3) {
				System.out.println("Invalid value. Choose 1, 2 or 3: ");
				continue;
			}

			return value;
		}
	}

	public static double readValidDouble(Scanner scanner) {
		while (true) {
			if (!scanner.hasNextDouble()) {
				scanner.next();
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			double value = scanner.nextDouble();

			if (value <= 0) {
				System.out.println("Invalid. Enter positive value: ");
				continue;
			}

			return value;
		}
	}

}

