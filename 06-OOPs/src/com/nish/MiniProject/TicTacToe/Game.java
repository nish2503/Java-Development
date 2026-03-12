package com.nish.MiniProject.TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Scanner scanner;

	public Game() {
		board = new Board();
		player1 = new Player('X');
		player2 = new Player('O');
		currentPlayer = player1;
		scanner = new Scanner(System.in);
	}

	public void start() {

		System.out.println("---- 2 Player TicTacToe ----");

		while (true) {

			board.printBoard();

			try {
				System.out.println("Player " + currentPlayer.getSymbol() + " turn");

				System.out.print("Enter row (1-3): ");
				int row = scanner.nextInt();

				System.out.print("Enter column (1-3): ");
				int col = scanner.nextInt();

				board.placeMove(row, col, currentPlayer.getSymbol());

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
		
		scanner.close();
	}
	private void switchPlayer() {
		currentPlayer = (currentPlayer == player1) ? player2 : player1;
	}
}