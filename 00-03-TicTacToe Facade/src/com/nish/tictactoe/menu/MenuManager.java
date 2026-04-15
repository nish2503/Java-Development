package com.nish.tictactoe.menu;

import com.nish.tictactoe.util.InputHandler;

public class MenuManager {

    private final InputHandler input = new InputHandler();

    public int showMainMenu() {
        System.out.println("\n1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Exit");

        return input.getIntInRange("Enter choice: ", 1, 3);
    }

    public int showPostGameMenu() {
        System.out.println("\n1. Replay same game");
        System.out.println("2. New game");
        System.out.println("3. Exit");

        return input.getIntInRange("Enter choice: ", 1, 3);
    }
}