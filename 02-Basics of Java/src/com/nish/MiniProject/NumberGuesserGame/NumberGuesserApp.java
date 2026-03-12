package com.nish.MiniProject.NumberGuesserGame;

import java.util.Scanner;

public class NumberGuesserApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		NumberGuesserModel game = new NumberGuesserModel();
		boolean playAgain = true;

		while (playAgain) {
			game.startGame(scanner);
			playAgain = InputValidator.askPlayAgain(scanner);
		}
		System.out.println("Thank you for playing!");
		scanner.close();
	}
}