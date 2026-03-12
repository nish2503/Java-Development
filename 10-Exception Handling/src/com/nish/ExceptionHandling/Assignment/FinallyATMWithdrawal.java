package com.nish.ExceptionHandling.Assignment;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FinallyATMWithdrawal {
	
	public static void main(String[] args) {
		int balance = 10000;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("Enter withdrawal amount: ");
				int amount = scanner.nextInt();
				if(amount <= 0) {
					throw new IllegalArgumentException("Amount must be positive!");
				}
				if(amount > balance) {
					throw new ArithmeticException("Insufficient Balance.");
				}
				balance -= amount;
				System.out.println("Withdrawed. Remaining Balance: " + balance);
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input!");
				scanner.nextLine();
			}
			finally {
				System.out.println("Transaction session ended.");
				System.out.println();
			}
		}
		scanner.close();		
	}

}
