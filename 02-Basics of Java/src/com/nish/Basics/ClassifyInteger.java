package com.nish.Basics;
import java.util.Scanner;

public class ClassifyInteger {

	public static void main(String[] args) {
		
		// Scanner object to store inputs
		Scanner scanner = new Scanner(System.in);
		
		// Take input number from user
		System.out.println("Enter number to be classified : ");
		int integer = scanner.nextInt();
		
		// Use conditional statements to classify number
		if(integer > 0) {
			System.out.println("Number is Positive");
		}
		else if (integer < 0) {
			System.out.println("Number is Negative");
		}
		else {
			System.out.println("Number is Zero");
		}
		
		scanner.close();
	}

}
