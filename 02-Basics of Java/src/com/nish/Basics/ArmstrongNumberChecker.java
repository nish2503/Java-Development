package com.nish.Basics;
import java.util.Scanner;

public class ArmstrongNumberChecker {

	public static void main(String[] args) {
		// Scanner object to store number
		Scanner scanner = new Scanner(System.in);
		
		// Take input number from user
		System.out.println("Enter number to be checked : ");
		int number = scanner.nextInt();
		
		// Conditional statements to check if number is prime
		if(isArmstrong(number)) {
			System.out.println("Armstrong Number");
		}
		else {
			System.out.println("Not Armstrong");
		}
		
		scanner.close();
	}
	
	public static boolean isArmstrong(int number) {
		int sum = 0;
		int originalNumber = number;
		while(number != 0) {
			int digit = number%10;
			sum += Math.pow(digit, 3);
			number /= 10;
		}
		
		if(sum == originalNumber) {
			return true;
		}
		else {
			return false;
		}
	}

}

