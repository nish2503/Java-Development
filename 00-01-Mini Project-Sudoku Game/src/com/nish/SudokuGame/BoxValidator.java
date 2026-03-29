package com.nish.SudokuGame;

public class BoxValidator extends SudokuValidator {

    @Override
    public boolean validate(SudokuBoard board) {

        int size = board.getSize();
        int boxSize = (int) Math.sqrt(size);

        for (int row = 0; row < size; row += boxSize) {

            for (int col = 0; col < size; col += boxSize) {

                boolean[] seen = new boolean[size + 1];

                for (int i = 0; i < boxSize; i++) {

                    for (int j = 0; j < boxSize; j++) {

                        int value = board.getValue(row + i, col + j);

                        if (value == 0) continue;

                        if (seen[value]) return false;

                        seen[value] = true;
                    }
                }
            }
        }

        return true;
    }
}