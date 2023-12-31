package games.ticTacToe;

import games.Figure;
import games.Move;

import java.util.Random;

public class RandomConsolePlayer extends AbstractConsolePlayer {
    public RandomConsolePlayer(Figure figure) {
        super("RandomPlayer", Integer.MAX_VALUE, figure);
    }

    private final Random random = new Random();
    @Override
    public Move move(final int xSize, final int ySize) {
        return new Move(random.nextInt(xSize) + 1, random.nextInt(ySize) + 1);
    }
}
