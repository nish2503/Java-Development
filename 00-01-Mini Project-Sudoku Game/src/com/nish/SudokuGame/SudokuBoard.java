package com.nish.SudokuGame;

public class SudokuBoard {

    private int[][] board;
    private boolean[][] fixed;
    private int size;

    public SudokuBoard(int[][] board) {
        this.board = board;
        this.size = board.length;

        fixed = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != 0) {
                    fixed[i][j] = true;
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getValue(int row, int col) {
        return board[row][col];
    }

    public void setValue(int row, int col, int value) throws InvalidSudokuException {

        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new InvalidSudokuException("Invalid position!");
        }

        if (value < 1 || value > size) {
            throw new InvalidSudokuException("Invalid value!");
        }

        if (fixed[row][col]) {
            throw new InvalidSudokuException("Cannot modify a fixed cell!");
        }

        if (!isSafe(row, col, value)) {
            throw new InvalidSudokuException("Move violates Sudoku rules!");
        }

        board[row][col] = value;
    }

    private boolean isSafe(int row, int col, int value) {

        for (int j = 0; j < size; j++) {
            if (board[row][j] == value) return false;
        }

        for (int i = 0; i < size; i++) {
            if (board[i][col] == value) return false;
        }

        int boxSize = (int) Math.sqrt(size);
        int startRow = row - row % boxSize;
        int startCol = col - col % boxSize;

        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (board[startRow + i][startCol + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isFull() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) return false;
            }
        }

        return true;
    }

    public void printBoard() {

        int boxSize = (int) Math.sqrt(size);

        int cellWidth = String.valueOf(size).length() + 1;

        System.out.println("\nCurrent Board:\n");

        for (int i = 0; i < size; i++) {

            if (i % boxSize == 0 && i != 0) {
                System.out.println();
            }

            for (int j = 0; j < size; j++) {

                if (j % boxSize == 0 && j != 0) {
                    System.out.print("  ");
                }

                String value = (board[i][j] == 0) ? "." : String.valueOf(board[i][j]);

                System.out.printf("%" + cellWidth + "s", value);
            }

            System.out.println();
        }
    }
}