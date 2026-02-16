package com.nish.whileLoop;
import java.util.Random;
import java.util.Scanner;

public class PigGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int turns = 0;

        System.out.println("Let's Play PIG!");
        System.out.println("* See how many turns it takes you to get to 20.");
        System.out.println("* Turn ends when you hold or roll a 1.");
        System.out.println("* If you roll a 1, you lose all points for the turn.");
        System.out.println("* If you hold, you save all points for the turn.");

        while (totalScore < 20) {

            turns++;
            int turnScore = 0;
            boolean turnOver = false;

            System.out.println("TURN " + turns);

            while (!turnOver) {

                System.out.print("Roll or hold? (r/h): ");
                String input = scanner.next();

                if (!input.equalsIgnoreCase("r") &&
                    !input.equalsIgnoreCase("h")) {
                    System.out.println("Invalid input. Please enter r or h.");
                    continue;
                }

                if (input.equalsIgnoreCase("h")) {
                    totalScore += turnScore;
                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore);
                    turnOver = true;
                } else {

                    int die = random.nextInt(6) + 1;
                    System.out.println("Die: " + die);

                    if (die == 1) {
                        System.out.println("Turn over. No score.");
                        turnScore = 0;
                        turnOver = true;
                    } else {
                        turnScore += die;
                    }
                }
            }
        }

        System.out.println("You finished in " + turns + " turns!");
        System.out.println("Game over!");

        scanner.close();
    }
}
