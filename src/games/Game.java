package games;

public class Game {
    private final TicTacToeBoard board;
    private final Player player1;
    private final Player player2;

    public Game(TicTacToeBoard board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player play() {
        board.clearBoard();
        System.out.println(board + "Player #1 please make a move");
        boolean nado = false;
        while (true) {
            if (!nado) {
                Move movePlayer = player1.move(board.getX(), board.getY());
                Result result = board.makeMove(movePlayer);
                if (result == Result.UNKNOWN) {
                } else if (result == Result.WIN) {
                    System.out.printf("Player #%d made a move (%d, %d) and he is won%n" + board, 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                    return player1;
                } else if (result == Result.LOSE) {
                    System.out.println("Wrong move, please try again");
                    continue;
                } else if (result == Result.DRAW) {
                    System.out.printf("Player #%d made a move (%d, %d) and it was a draw%n" + board, 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                    return null;
                } else {
                    throw new IllegalArgumentException("Unexpected result: " + result);
                }
                System.out.printf("Player #%d made a move (%d, %d)%n" + board, 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                System.out.printf("Player #%d please make a move%n%n%n", 2);
            }


            Move movePlayer = player2.move(board.getX(), board.getY());
            Result result = board.makeMove(movePlayer);
            nado = false;
            if (result == Result.UNKNOWN) {
            } else if (result == Result.WIN) {
                System.out.printf("Player #%d made a move (%d, %d) and he is won%n" + board, 2, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                return player2;
            } else if (result == Result.LOSE) {
                System.out.println("Wrong move, please try again");
                nado = true;
            } else if (result == Result.DRAW) {
                System.out.printf("Player #%d made a move (%d, %d) and it was a draw%n" + board, 2, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                return null;
            } else {
                throw new IllegalArgumentException("Unexpected result: " + result);
            }
            if (!nado) {
                System.out.printf("Player #%d made a move (%d, %d)%n" + board, 2, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                System.out.printf("Player #%d please make a move%n%n%n", 1);
            }
        }
    }
}
