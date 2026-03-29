package com.nish.SudokuGame;

public class RowValidator extends SudokuValidator {

    @Override
    public boolean validate(SudokuBoard board) {

        int size = board.getSize();

        for (int i = 0; i < size; i++) {

            boolean[] seen = new boolean[size + 1];

            for (int j = 0; j < size; j++) {

                int value = board.getValue(i, j);

                if (value == 0) continue;

                if (seen[value]) return false;

                seen[value] = true;
            }
        }

        return true;
    }
}