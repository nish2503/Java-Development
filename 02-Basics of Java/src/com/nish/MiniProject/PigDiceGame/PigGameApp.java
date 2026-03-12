package com.nish.MiniProject.PigDiceGame;
import java.util.Scanner;

public class PigGameApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PigGameModel game = new PigGameModel();
        game.play(scanner);

        scanner.close();
    }
}