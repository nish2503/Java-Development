package com.nish.Interface.Test;

import java.util.Scanner;

import com.nish.Interface.Model.CreditCardPayment;
import com.nish.Interface.Model.Payment;
import com.nish.Interface.Model.UPIPayment;
import com.nish.Interface.Model.DebitCardPayment;


public class PaymentApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter payment amount: ");
		double amount = readValidDouble(scanner);
		
		System.out.println("Choose payment method: ");
		System.out.println("1. Credit Card");
		System.out.println("2. Debit Card");
		System.out.println("3. UPI");
		int n = readValidChoice(scanner);
//		scanner.nextLine();
		
		Payment payment = null;
		
		switch(n) {
		case 1:
			payment = new CreditCardPayment(amount);
			break;
		case 2:
			payment = new DebitCardPayment(amount);
			break;
		case 3:
			payment = new UPIPayment(amount);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		
		if(payment!=null) {
			payment.processPayment();
		}
		
		scanner.close();
	}
	
	public static int readValidChoice(Scanner scanner) {
		while(true) {
			if(!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("Invalid. Choose 1, 2 or 3: ");
				continue;
			}
			int value = scanner.nextInt();
			if(value <= 0) {
				System.out.println("Invalid. Choose 1, 2 or 3: ");
				continue;
			}
			return value;
		}
	}
	
	public static double readValidDouble(Scanner scanner) {
		while(true) {
			if(!scanner.hasNextDouble()) {
				scanner.nextLine();
				System.out.println("Invalid. Enter again: ");
				continue;
			}
			double value = scanner.nextDouble();
			if(value <= 0) {
				System.out.println("Invalid. Enter again: ");
				continue;
			}
			return value;
		}
	}
}
