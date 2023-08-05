package games.ticTacToe;

import games.Game;
import games.Move;
import games.Player;
import games.Result;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe implements Game {
    private final TicTacToeBoard board;
    private final TicTacToeRules rules;
    private final List<Player> playerList;

    public TicTacToe(Player... players) {
        this(new TicTacToeRules(), players);
    }

    public TicTacToe(TicTacToeRules rules, Player... players) {
        this.board = new TicTacToeBoard(rules);
        this.rules = rules;
        this.playerList = new ArrayList<>(List.of(players));
    }

    @Override
    public Player play() {
        board.clearBoard();
        System.out.printf(board.draw() + "Player #1 please make a move:%n%n");
        int index = 0;
        while (true) {
            Player player = playerList.get(index);
            Move movePlayer = player.move(rules.getxSize(), rules.getySize());
            Result result = board.makeMove(movePlayer);
            switch (result) {
                case UNKNOWN -> {
                }
                case WIN -> {
                    System.out.printf("Player #%d made a move (%d, %d) and he is won%n" + board.draw(), index + 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                    return player;
                }
                case LOSE -> {
                    System.out.println("Wrong move, please try again");
                    continue;
                }
                case DRAW -> {
                    System.out.printf("Player #%d made a move (%d, %d) and it was a draw%n" + board.draw(), index + 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                    return null;
                }
                default -> throw new IllegalArgumentException("Unexpected result: " + result);
            }
            System.out.printf("Player #%d made a move (%d, %d)%n" + board.draw(), index + 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
            index = (index + 1) % playerList.size();
            System.out.printf("Player #%d please make a move:%n%n", index + 1);
        }
    }

    public void changeBoardSize(final int x, final int y) {
        if (x < 1 || y < 1) {
            throw new IllegalArgumentException("Field dimensions must be positive and integer");
        }
        rules.setxSize(x);
        rules.setySize(y);
        board.changeFieldSize();
    }

    public void changeCountCrossedCells(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Expected to be a positive integer");
        } else if (count > rules.getxSize() || count > rules.getySize()) {
            throw new IllegalArgumentException("The number of crossed out cells exceeds the size of the field");
        }
        rules.setCountCrossedCells(count);
    }

    public void printRules() {
        System.out.println(rules.getInfo());
    }
}
