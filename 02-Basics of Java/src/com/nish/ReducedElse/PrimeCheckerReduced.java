package com.nish.ReducedElse;

import java.util.Scanner;

class PrimeCheckerReduced {

	public static boolean isPrime(int number) {

		if (number <= 1) {
			return false;
		}

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number to check : ");
		int number = scanner.nextInt();

		if (!isPrime(number)) {
			System.out.println(number + " is Not Prime");
			return;
		}
		System.out.println(number + " is Prime");
	}
}
