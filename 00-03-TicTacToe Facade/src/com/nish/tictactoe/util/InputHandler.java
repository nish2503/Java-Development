package com.nish.tictactoe.util;
import java.util.Scanner;

import com.nish.tictactoe.exception.InvalidInputException;
import com.nish.tictactoe.player.HumanPlayer;
import com.nish.tictactoe.player.Player;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public int getIntInRange(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int val = Integer.parseInt(scanner.nextLine());

                if (val < min || val > max)
                    throw new InvalidInputException("Out of range");

                return val;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public String getValidName(String msg) {
        while (true) {
            System.out.print(msg);
            String name = scanner.nextLine().trim().replaceAll("\\s+", " ");

            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                return name;
            }
            System.out.println("Invalid name. Only alphabets allowed.");
        }
    }

    public char getSymbol(String msg) {
        while (true) {
            System.out.print(msg);
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("X") || input.equals("O"))
                return input.charAt(0);

            System.out.println("Choose only X or O.");
        }
    }

    public int getBoardSize() {
        return getIntInRange("Enter board size (>=3): ", 3, 10);
    }

    public Player createPlayer(String label) {
        String name = getValidName(label + " name: ");
        char symbol = getSymbol(label + " choose symbol (X/O): ");
        return new HumanPlayer(name, symbol);
    }

    public int getMove(int max) {
        return getIntInRange("Enter move (1-" + max + "): ", 1, max);
    }
}