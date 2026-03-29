package com.nish.SudokuGame;

import java.util.Random;

public class SudokuGenerator {

    public static int[][] generateBoard(int size, int filledCells) {

        int[][] board = generateFullBoard(size);

        int totalCells = size * size;
        int remove = totalCells - filledCells;

        removeCells(board, size, remove);

        return board;
    }

    private static int[][] generateFullBoard(int size) {

        int[][] board = new int[size][size];
        int boxSize = (int) Math.sqrt(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = (i * boxSize + i / boxSize + j) % size + 1;
            }
        }

        shuffle(board, size);
        return board;
    }

    private static void shuffle(int[][] board, int size) {

        Random rand = new Random();
        int boxSize = (int) Math.sqrt(size);

        for (int band = 0; band < size; band += boxSize) {

            for (int i = 0; i < boxSize; i++) {

                int r1 = band + i;
                int r2 = band + rand.nextInt(boxSize);

                int[] temp = board[r1];
                board[r1] = board[r2];
                board[r2] = temp;
            }
        }
    }

    private static void removeCells(int[][] board, int size, int count) {

        Random rand = new Random();

        while (count > 0) {

            int row = rand.nextInt(size);
            int col = rand.nextInt(size);

            if (board[row][col] != 0) {
                board[row][col] = 0;
                count--;
            }
        }
    }
}