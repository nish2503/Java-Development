package com.nish.SudokuGame;

public class SudokuValidatorEngine {

    private RowValidator rowValidator = new RowValidator();
    private ColumnValidator columnValidator = new ColumnValidator();
    private BoxValidator boxValidator = new BoxValidator();

    public boolean validateSudoku(SudokuBoard board) {
        return rowValidator.validate(board)
                && columnValidator.validate(board)
                && boxValidator.validate(board);
    }
}