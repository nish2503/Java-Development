package com.nish.MiniProject.TicTacToeV2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;
    private boolean vsComputer;
    private Random random;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
        setupGame();
    }

//    private void setupGame() {
//
//        board = new Board();
//
//        System.out.println("Play with:");
//        System.out.println("1. Human");
//        System.out.println("2. Computer");
//
//        int choice = scanner.nextInt();
//        vsComputer = (choice == 2);
//
//        System.out.print("Choose your symbol (X/O): ");
//        char symbol = scanner.next().toUpperCase().charAt(0);
//
//        char otherSymbol = (symbol == 'X') ? 'O' : 'X';
//
//        player1 = new Player(symbol);
//        player2 = new Player(otherSymbol);
//
//        currentPlayer = player1;
//    }
    
    private void setupGame() {

        board = new Board();

        System.out.println("Play with:");
        System.out.println("1. Human");
        System.out.println("2. Computer");

        int choice = scanner.nextInt();
        vsComputer = (choice == 2);

        System.out.print("Player 1 choose your symbol: ");
        char symbol1 = scanner.next().charAt(0);

        char symbol2;

        if (vsComputer) {

            symbol2 = 'O';
            if (symbol1 == 'O') {
                symbol2 = 'X';
            }

            System.out.println("Computer symbol is: " + symbol2);

        } else {

            while (true) {

                System.out.print("Player 2 choose your symbol: ");
                symbol2 = scanner.next().charAt(0);

                if (symbol2 != symbol1)
                    break;

                System.out.println("Symbol already taken! Choose another.");
            }
        }

        player1 = new Player(symbol1);
        player2 = new Player(symbol2);

        currentPlayer = player1;
    }

    public void start() {

        while (true) {

            System.out.println("---- TicTacToe ----");

            while (true) {

                board.printBoard();

                try {

                    if (vsComputer && currentPlayer == player2) {

                        computerMove();

                    } else {

                        System.out.println("Player " + currentPlayer.getSymbol() + " turn");

                        System.out.print("Enter position (1-9): ");
                        int position = scanner.nextInt();

                        board.placeMove(position, currentPlayer.getSymbol());
                    }

                    if (board.checkWin(currentPlayer.getSymbol())) {
                        board.printBoard();
                        System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                        break;
                    }

                    if (board.isFull()) {
                        board.printBoard();
                        System.out.println("Game Draw!");
                        break;
                    }

                    switchPlayer();

                } catch (InputMismatchException e) {
                    System.out.println("Please enter numbers only!");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (!playAgain()) {
                System.out.println("Thanks for playing!");
                break;
            }

            setupGame();
        }

        scanner.close();
    }

    private void computerMove() {

        System.out.println("Computer is playing...");

        while (true) {

            int position = random.nextInt(9) + 1;

            try {
                board.placeMove(position, currentPlayer.getSymbol());
                System.out.println("Computer chose position " + position);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private boolean playAgain() {

        System.out.println("Play again? (y/n)");
        char choice = scanner.next().toLowerCase().charAt(0);

        return choice == 'y';
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}