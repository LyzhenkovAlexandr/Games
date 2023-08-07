package games.ticTacToe;

import games.Move;

public class HumanConsolePlayer extends AbstractConsolePlayer {
    public HumanConsolePlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public Move move(final int xSize, final int ySize) {
        int col = in.nextInt() - 1;
        int row = in.nextInt() - 1;
        return new Move(row, col);
    }
}
