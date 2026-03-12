package com.nish.MiniProject.PigDiceGame;

import java.util.Scanner;

public class InputValidator {

	public static char readChoice(Scanner scanner) {

		while (true) {

			System.out.print("Roll or hold? (r/h): ");
			String input = scanner.next().toLowerCase();

			if (input.equals("r") || input.equals("h")) {
				return input.charAt(0);
			}

			System.out.println("Invalid input. Please enter r or h.");
		}
	}
}