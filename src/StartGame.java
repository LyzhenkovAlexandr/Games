import games.*;

public class StartGame {
    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        Player player1 = new HumanPlayer();
        Player player2 = new RandomPlayer();
        Game tictactoe = new Game(board, player1, player2);
        Player winner = tictactoe.play();

    }
}
