package com.nish.tictactoe.game;

import com.nish.tictactoe.exception.InvalidMoveException;

public class Board {

	private final char[][] grid;
	private final int size;

	public Board(int size) {
		this.size = size;
		grid = new char[size][size];
	}

	public void printBoard() {
		int count = 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[i][j] == '\0') {
					System.out.print(String.format("%2d", count));
				} else {
					System.out.print(" " + grid[i][j]);
				}
				if (j < size - 1) {
					System.out.print(" |");
				}
				count++;
			}
			System.out.println();

			if (i < size - 1) {
				for (int k = 0; k < size; k++) {
					System.out.print("---");
					if (k < size - 1) {
						System.out.print("+");
					}
				}
				System.out.println();
			}
		}
		System.out.println();
	}

	public void makeMove(int pos, char symbol) throws InvalidMoveException {
		int row = (pos - 1) / size;
		int col = (pos - 1) % size;

		if (grid[row][col] != '\0') {
			throw new InvalidMoveException("Cell already occupied");
		}
		grid[row][col] = symbol;
	}

	public boolean isFull() {
		for (char[] row : grid) {
			for (char c : row) {
				if (c == '\0') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkWin(char s) {
		for (int i = 0; i < size; i++) {
			boolean row = true, col = true;

			for (int j = 0; j < size; j++) {
				if (grid[i][j] != s) {
					row = false;
				}
				if (grid[j][i] != s) {
					col = false;
				}
			}
			if (row || col) {
				return true;
			}
		}

		boolean diagonal1 = true, diagonal2 = true;
		for (int i = 0; i < size; i++) {
			if (grid[i][i] != s) {
				diagonal1 = false;
			}
			if (grid[i][size - i - 1] != s) {
				diagonal2 = false;
			}
		}
		return diagonal1 || diagonal2;
	}
}