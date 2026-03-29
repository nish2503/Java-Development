package com.nish.SudokuGame;

public class ColumnValidator extends SudokuValidator {

    @Override
    public boolean validate(SudokuBoard board) {

        int size = board.getSize();

        for (int j = 0; j < size; j++) {

            boolean[] seen = new boolean[size + 1];

            for (int i = 0; i < size; i++) {

                int value = board.getValue(i, j);

                if (value == 0) continue;

                if (seen[value]) return false;

                seen[value] = true;
            }
        }

        return true;
    }
}