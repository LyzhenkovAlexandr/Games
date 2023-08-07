package games;

import games.figures.O;
import games.figures.X;
import games.ticTacToe.HumanConsolePlayer;
import games.ticTacToe.RandomConsolePlayer;
import games.ticTacToe.TicTacToe;

public class StartGame {
    public static void main(String[] args) {
        Player player1 = new HumanConsolePlayer("Alexander", 18, new X());
        Player player2 = new RandomConsolePlayer(new X());
        TicTacToe tictactoe = new TicTacToe(player1, player2);
        tictactoe.changeBoardSize(7, 5);
        tictactoe.changeCountCrossedCells(4);
        Player winner = tictactoe.play();
    }
}
