package com.nish.MiniProject.TicTacToe;

public class Board {

	private char[][] board = new char[3][3];

	public Board() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void printBoard() {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print(" ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
				if (j < 2)
					System.out.print(" | ");
			}
			System.out.println();
			if (i < 2)
				System.out.println("---+---+---");
		}
		System.out.println();
	}

	public void placeMove(int row, int col, char symbol) {

		if (row < 1 || row > 3 || col < 1 || col > 3) {
			throw new IllegalArgumentException("Row and Column must be between 1 and 3.");
		}

		if (board[row - 1][col - 1] != ' ') {
			throw new IllegalArgumentException("Cell already occupied!");
		}

		board[row - 1][col - 1] = symbol;
	}

	public boolean checkWin(char symbol) {

		for (int i = 0; i < 3; i++) {
			if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
				return true;
		}

		for (int j = 0; j < 3; j++) {
			if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol)
				return true;
		}

		if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
			return true;

		if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
			return true;

		return false;
	}

	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ')
					return false;
			}
		}
		return true;
	}
}