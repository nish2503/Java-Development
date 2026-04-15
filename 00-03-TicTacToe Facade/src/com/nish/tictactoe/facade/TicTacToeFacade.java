package com.nish.tictactoe.facade;

import com.nish.tictactoe.game.GameService;
import com.nish.tictactoe.menu.MenuManager;
import com.nish.tictactoe.player.ComputerPlayer;
import com.nish.tictactoe.player.Player;
import com.nish.tictactoe.util.InputHandler;

public class TicTacToeFacade {

    private final MenuManager menu = new MenuManager();
    private final InputHandler input = new InputHandler();
    private final GameService gameService = new GameService();

    public void start() {
        while (true) {
            int choice = menu.showMainMenu();

            if (choice == 3) {
                System.out.println("Exiting...");
                return;
            }

            int size = input.getBoardSize();

            Player player1 = input.createPlayer("Player 1");
            Player player2 = (choice == 1)
                    ? input.createPlayer("Player 2")
                    : new ComputerPlayer("Computer", player1.getOpponentSymbol());

            handleGame(size, player1, player2);
        }
    }

    private void handleGame(int size, Player player1, Player player2) {
        while (true) {
            gameService.playGame(size, player1, player2);

            int choice = menu.showPostGameMenu();

            if (choice == 1) continue;
            if (choice == 2) return;  
            System.exit(0);
        }
    }
}