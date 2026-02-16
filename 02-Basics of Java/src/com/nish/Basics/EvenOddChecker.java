package com.nish.Basics;
import java.util.Scanner;

public class EvenOddChecker {

	public static void main(String[] args) {
		// Scanner object to store number
		Scanner scanner = new Scanner(System.in);

		// Take input number from user
		System.out.println("Enter number to be checked : ");
		int number = scanner.nextInt();

		// Conditional statements to classify number into odd and even
		if (number % 2 == 0) {
			System.out.println("Number is Even");
		} else {
			System.out.println("Number is Odd");
		}

		scanner.close();
	}

}
