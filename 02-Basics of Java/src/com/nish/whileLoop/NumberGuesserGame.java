package com.nish.whileLoop;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesserGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {

            int randomNumber = random.nextInt(100) + 1; // 1–100
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Game Started!");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("Maximum possible attempts -> " + maxAttempts);

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Sorry, Too Low");
                } else if (guess > randomNumber) {
                    System.out.println("Sorry, Too High");
                } else {
                    System.out.println("You won in attempt: " + attempts);
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Game Over! The correct number was: " + randomNumber);
            }

            // Play again validation
            while (true) {
                System.out.print("Do you want to play again? (yes/no): ");
                String response = scanner.next();

                if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
                    playAgain = true;
                    break;
                } else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")) {
                    playAgain = false;
                    break;
                } else {
                    System.out.println("Invalid input. Please type yes or no.");
                }
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
