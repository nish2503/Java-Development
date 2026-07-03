package com.expenseapp.exception;

public class DuplicateBudgetException extends RuntimeException {
    public DuplicateBudgetException(String message) {
        super(message);
    }
}
