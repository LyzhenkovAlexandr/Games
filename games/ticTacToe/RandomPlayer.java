package games.ticTacToe;

import games.Move;
import games.Player;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random = new Random();
    @Override
    public Move move(final int xSize, final int ySize) {
        return new Move(random.nextInt(xSize) + 1, random.nextInt(ySize) + 1);
    }
}
