package com.nish.tictactoe.player;

import com.nish.tictactoe.util.InputHandler;

public class HumanPlayer extends Player {

    private final InputHandler input = new InputHandler();

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int makeMove(int max) {
        return input.getMove(max);
    }
}