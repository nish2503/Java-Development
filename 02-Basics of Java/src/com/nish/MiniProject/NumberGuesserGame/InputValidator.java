package com.nish.MiniProject.NumberGuesserGame;

import java.util.Scanner;

public class InputValidator {

	public static int readGuess(Scanner scanner) {

		while (true) {
			System.out.print("Enter your guess: ");

			if (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
				continue;
			}
			int guess = scanner.nextInt();
			if (guess < 1 || guess > 100) {
				System.out.println("Please enter a number between 1 and 100.");
				continue;
			}
			return guess;
		}
	}

	public static boolean askPlayAgain(Scanner scanner) {

		while (true) {
			System.out.print("Do you want to play again? (yes/no): ");
			String response = scanner.next();

			if (response.equalsIgnoreCase("yes")) {
				return true;
			}
			if (response.equalsIgnoreCase("no")) {
				return false;
			}
			System.out.println("Invalid input. Type yes or no.");
		}
	}
}