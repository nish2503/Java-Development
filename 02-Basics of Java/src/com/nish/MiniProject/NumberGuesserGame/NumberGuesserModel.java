package com.nish.MiniProject.NumberGuesserGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesserModel {

	private static final int MAX_ATTEMPTS = 5;
	private final Random random = new Random();

	public void startGame(Scanner scanner) {

		int targetNumber = random.nextInt(100) + 1;
		int attempts = 0;
		boolean guessedCorrectly = false;

		System.out.println("\nNew Game Started!");
		System.out.println("Guess a number between 1 and 100: ");
		System.out.println("Maximum attempts: " + MAX_ATTEMPTS);

		while (attempts < MAX_ATTEMPTS) {
			int guess = InputValidator.readGuess(scanner);
			attempts++;

			if (guess < targetNumber) {
				System.out.println("Too Low");
			} else if (guess > targetNumber) {
				System.out.println("Too High");
			} else {
				System.out.println("You won in attempt: " + attempts);
				guessedCorrectly = true;
				break;
			}
		}

		if (!guessedCorrectly) {
			System.out.println("Game Over! Correct number was: " + targetNumber);
		}
	}
}