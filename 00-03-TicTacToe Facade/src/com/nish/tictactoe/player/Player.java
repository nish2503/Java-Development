package com.nish.tictactoe.player;

public abstract class Player {
    protected String name;
    protected char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public abstract int makeMove(int max);

    public char getSymbol() {
        return symbol;
    }

    public char getOpponentSymbol() {
        return symbol == 'X' ? 'O' : 'X';
    }

    public String getName() {
        return name;
    }
}