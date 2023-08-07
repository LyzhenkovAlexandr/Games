package games;

import games.ticTacToe.HumanConsolePlayer;
import games.ticTacToe.RandomConsolePlayer;
import games.ticTacToe.TicTacToe;

public class StartGame {
    public static void main(String[] args) {
        Player player1 = new HumanConsolePlayer("Alexander", 18);
        Player player2 = new RandomConsolePlayer();
        TicTacToe tictactoe = new TicTacToe(player1, player2);
        tictactoe.changeBoardSize(7, 5);
        tictactoe.changeCountCrossedCells(4);
        Player winner = tictactoe.play();
    }
}
