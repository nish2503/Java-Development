package com.nish.SudokuGame;

import java.util.Scanner;

public class SudokuGame {

    private SudokuBoard board;
    private SudokuValidatorEngine validator;
    private Scanner scanner;

    public SudokuGame() {
        validator = new SudokuValidatorEngine();
        scanner = new Scanner(System.in);
        initializeBoard();
    }

    private void initializeBoard() {

        System.out.print("Enter board size: ");
        int size = readInt();

        int root = (int) Math.sqrt(size);
        while (root * root != size) {
            System.out.print("Size must be perfect square. Try again: ");
            size = readInt();
            root = (int) Math.sqrt(size);
        }

        int total = size * size;

        System.out.print("Enter filled cells (0-" + total + "): ");
        int filled = readIntInRange(0, total);

        int[][] grid = SudokuGenerator.generateBoard(size, filled);
        board = new SudokuBoard(grid);

        board.printBoard();
    }

    public void startGame() {

        int choice;

        do {
            showMenu();
            choice = readInt();

            switch (choice) {
                case 1 -> placeNumber();
                case 2 -> validateBoard();
                case 3 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice");
            }

        } while (choice != 3);
    }

    private void placeNumber() {

        int size = board.getSize();

        System.out.print("Row: ");
        int row = readIntInRange(0, size - 1);

        System.out.print("Col: ");
        int col = readIntInRange(0, size - 1);

        System.out.print("Value: ");
        int value = readIntInRange(1, size);

        try {
            board.setValue(row, col, value);
        } catch (InvalidSudokuException e) {
            System.out.println(e.getMessage());
        }

        board.printBoard();

        if (board.isFull()) {

            System.out.println("\nBoard complete! Checking...\n");

            boolean valid = validator.validateSudoku(board);

            if (valid) {
                System.out.println("Congratulations! Sudoku solved correctly!");
            } else {
                System.out.println("Board filled but incorrect.");
            }

            restartOrExit();
        }
    }

    private void validateBoard() {
        System.out.println(
                validator.validateSudoku(board) ? "Valid Sudoku" : "Invalid Sudoku"
        );
    }

    private void restartOrExit() {

        System.out.println("\n1. Start New Game");
        System.out.println("2. Exit");

        int choice = readIntInRange(1, 2);

        if (choice == 1) {
            initializeBoard();
        } else {
            System.out.println("Exiting... Goodbye!");
            System.exit(0);
        }
    }

    private void showMenu() {
        System.out.println("\n1. Place Number");
        System.out.println("2. Validate Board");
        System.out.println("3. Exit");
        System.out.println();
        System.out.println("Enter: ");
    }

    // Input Validation

    private int readInt() {

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private int readIntInRange(int min, int max) {

        int val;

        while (true) {
            val = readInt();

            if (val >= min && val <= max) return val;

            System.out.print("Enter between " + min + "-" + max + ": ");
        }
    }
}