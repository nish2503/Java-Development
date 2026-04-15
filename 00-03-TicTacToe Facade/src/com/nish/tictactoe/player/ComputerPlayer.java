package com.nish.tictactoe.player;

import java.util.Random;

public class ComputerPlayer extends Player {

    private final Random random = new Random();

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int makeMove(int max) {
        return random.nextInt(max) + 1;
    }
}