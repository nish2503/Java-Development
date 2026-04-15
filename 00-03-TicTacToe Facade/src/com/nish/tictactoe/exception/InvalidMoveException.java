package com.nish.tictactoe.exception;

public class InvalidMoveException extends Exception {
    public InvalidMoveException(String msg) {
        super(msg);
    }
}