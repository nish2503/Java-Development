package com.nish.Basics;
import java.util.Scanner;

public class PrimeNumberChecker {

	public static void main(String[] args) {
		// Scanner object to store number
		Scanner scanner = new Scanner(System.in);
		
		// Take input number from user
		System.out.println("Enter number to be checked : ");
		int number = scanner.nextInt();
		
		// Conditional statements to check if number is prime
		if(isPrime(number)) {
			System.out.println("Prime Number");
		}
		else {
			System.out.println("Not Prime");
		}
		
		scanner.close();
	}
	
	public static boolean isPrime(int number) {
		if(number <= 1) {
			return false;
		}
		for(int i=2; i*i<=number; i++) {
			if(number%i == 0) {
				return false;
			}
		}
		return true;
	}

}
