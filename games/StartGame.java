package games;

import games.ticTacToe.HumanPlayer;
import games.ticTacToe.RandomPlayer;
import games.ticTacToe.TicTacToe;
import games.ticTacToe.TicTacToeRules;

public class StartGame {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer();
        Player player2 = new RandomPlayer();
        TicTacToe tictactoe = new TicTacToe(player1, player2);
        tictactoe.changeBoardSize(4, 3);
        Player winner = tictactoe.play();
        TicTacToeRules rules = new TicTacToeRules();
    }
}
