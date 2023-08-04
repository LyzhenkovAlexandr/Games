package games;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random = new Random();
    @Override
    public Move move(final int x, final int y) {
        return new Move(random.nextInt(x) + 1, random.nextInt(y) + 1);
    }
}
