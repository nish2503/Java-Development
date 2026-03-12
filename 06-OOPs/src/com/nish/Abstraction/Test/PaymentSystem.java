package com.nish.Abstraction.Test;
import java.util.Scanner;

import com.nish.Abstraction.Model.CreditCardPayment;
import com.nish.Abstraction.Model.Payment;
import com.nish.Abstraction.Model.UPIPayment;
import com.nish.Abstraction.Model.WalletPayment;


public class PaymentSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------ WELCOME TO PAYMENT GATEWAY ------");
		System.out.println("Enter number of payments :");
		int n = readValidInt(scanner);
		scanner.nextLine();
		
		Payment[] payments = new Payment[n];
		
		for(int i=0; i<n; i++) {
			System.out.println("\nPayment " + (i+1) + ":");
			System.out.println("Enter Payment ID (eg. PNUM1234) :");
			String paymentId = readValidId(scanner);
			System.out.println("Enter Amount :");
			double amount = readValidDouble(scanner);
			
			System.out.println("Enter payment type :");
			System.out.println("1. Credit Card (2% fee)");
			System.out.println("2. UPI");
			System.out.println("3. Wallet (1% fee)");
			
			int choice = readValidChoice(scanner);
			
			switch(choice) {
			
			case 1: 
				payments[i] = new CreditCardPayment(paymentId, amount);
				break;
			case 2:
				payments[i] = new UPIPayment(paymentId, amount);
				break;	
			case 3:
				payments[i] = new WalletPayment(paymentId, amount);
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
				
		System.out.println("\n--- PAYMENTS ---");
		System.out.println();
		
		for(Payment p:payments) {
			if(p.validateAmount()) {
				double finalAmount = p.processPayment();
				p.generateReciept(finalAmount);
				System.out.println("------------------");
			}
		}
		scanner.close();
	}
	
	public static int readValidInt(Scanner scanner) {
		while(true) {
			if(!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("Invalid input. Enter integer :");
				continue;
			}
			int value = scanner.nextInt();
			if(value <= 0) {
				System.out.println("Invalid. Enter positive integer :");
				continue;
			}
			return value;
		}
	}
	
	public static String readValidId(Scanner scanner) {

		while (true) {

			String courseId = scanner.nextLine().trim();

			if (!courseId.matches("^PNUM\\d{6}$")) {
				System.out.println("Invalid input. Enter again :");
				continue;
			}

			return courseId;
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
			scanner.nextLine();

			if (value <= 0) {
				System.out.println("Invalid. Enter positive value: ");
				continue;
			}

			return value;
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
			scanner.nextLine();

			if (value < 1 || value > 3) {
				System.out.println("Invalid value. Choose 1, 2 or 3: ");
				continue;
			}

			return value;
		}
	}
}
