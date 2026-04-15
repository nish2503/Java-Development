package com.nish.tictactoe.game;

import com.nish.tictactoe.exception.InvalidMoveException;
import com.nish.tictactoe.player.Player;

public class GameService {

    public void playGame(int size, Player player1, Player player2) {

        Board board = new Board(size);
        Player current = player1;

        while (true) {
        	System.out.println();
            board.printBoard();
            System.out.println(current.getName() + "'s turn");

            try {
                int move = current.makeMove(size * size);
                board.makeMove(move, current.getSymbol());

                if (board.checkWin(current.getSymbol())) {
                    board.printBoard();
                    System.out.println(current.getName() + " wins!");
                    return;
                }

                if (board.isFull()) {
                    board.printBoard();
                    System.out.println("Draw!");
                    return;
                }

                current = (current == player1) ? player2 : player1;

            } catch (InvalidMoveException e) {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}