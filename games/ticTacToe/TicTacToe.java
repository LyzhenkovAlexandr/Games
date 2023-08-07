package games.ticTacToe;

import games.Game;
import games.Move;
import games.Player;
import games.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicTacToe implements Game {
    private final TicTacToeBoard board;
    private final TicTacToeRules rules;
    private final List<Player> playerList;

    public TicTacToe(Player... players) {
        this(new TicTacToeRules(), players);
    }

    public TicTacToe(TicTacToeRules rules, Player... players) {
        Objects.requireNonNull(rules);
        if (players.length < 1) {
            throw new IllegalArgumentException("Expected at least one player");
        }
        this.board = new TicTacToeBoard(rules);
        this.rules = rules;
        this.playerList = new ArrayList<>(List.of(players));
    }

    @Override
    public Player play() {
        board.clearBoard();
        playerList.get(0).drawBoard(board);
        System.out.printf("Player #1 please make a move:%n%n");
        int index = 0;
        while (true) {
            Player player = playerList.get(index);
            Move movePlayer = player.move(rules.getxSize(), rules.getySize());
            Result result = board.makeMove(movePlayer);
            switch (result) {
                case UNKNOWN -> {
                }
                case WIN -> {
                    System.out.printf("Player #%d made a move (%d, %d) and he is won%n", index + 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                    player.drawBoard(board);
                    return player;
                }
                case LOSE -> {
                    System.out.println("Wrong move, please try again");
                    continue;
                }
                case DRAW -> {
                    System.out.printf("Player #%d made a move (%d, %d) and it was a draw%n", index + 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
                    player.drawBoard(board);
                    return null;
                }
                default -> throw new IllegalArgumentException("Unexpected result: " + result);
            }
            System.out.printf("Player #%d made a move (%d, %d)%n", index + 1, movePlayer.getRow() + 1, movePlayer.getCol() + 1);
            player.drawBoard(board);
            index = (index + 1) % playerList.size();
            System.out.printf("Player #%d please make a move:%n%n", index + 1);
        }
    }

    public void changeBoardSize(final int x, final int y) {
        if (x < rules.getMinxSize() || y < rules.getMinySize() || x > rules.getMaxxSize() || y > rules.getMaxySize()) {
            throw new IllegalArgumentException("The field sizes must be positive integers and within the allowed values.");
        }
        rules.setxSize(x);
        rules.setySize(y);
        board.updateFieldSize();
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
