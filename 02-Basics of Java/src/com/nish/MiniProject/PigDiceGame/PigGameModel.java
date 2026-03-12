package com.nish.MiniProject.PigDiceGame;
import java.util.Random;
import java.util.Scanner;

public class PigGameModel {

    private static final int TARGET_SCORE = 20;
    private final Random random = new Random();

    public void play(Scanner scanner) {

        int totalScore = 0;
        int turn = 1;

        System.out.println("Let's Play PIG!");
        System.out.println("* See how many turns it takes you to get to 20.");
        System.out.println("* Turn ends when you hold or roll a 1.");
        System.out.println("* If you roll a 1, you lose all points for the turn.");
        System.out.println("* If you hold, you save all points for the turn.\n");

        while (totalScore < TARGET_SCORE) {

            int turnScore = 0;
            boolean turnOver = false;

            System.out.println("TURN " + turn);

            while (!turnOver) {

                char choice = InputValidator.readChoice(scanner);

                if (choice == 'r') {
                    int die = random.nextInt(6) + 1;
                    System.out.println("Die: " + die);
                    
                    if (die == 1) {
                    	System.out.println("Turn over. No score.\n");
                        turnScore = 0;
                        turnOver = true;
                    } else {
                        turnScore += die;
                    }   
                } else {
                    totalScore += turnScore;
                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore + "\n");
                    turnOver = true;
                }
            }
            turn++;
        }
        System.out.println("You finished in " + (turn - 1) + " turns!");
        System.out.println("Game over!");
    }
}