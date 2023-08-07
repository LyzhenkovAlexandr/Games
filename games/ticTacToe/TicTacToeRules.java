package games.ticTacToe;

import games.AbstractRules;

public class TicTacToeRules extends AbstractRules {
    private int countCrossedCells = 3;

    public TicTacToeRules() {
        super(1, 1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 2);
        setArguments(3, 3, 2);
    }

    public TicTacToeRules(int xSize, int ySize, int countPlayers, int countCrossedCells) {
        super(1, 1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 2);
        setArguments(xSize, ySize, countPlayers);
        checkCountCrossedCells(countCrossedCells);
        this.countCrossedCells = countCrossedCells;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "required number of characters in a row to win: " + countCrossedCells;
    }

    private void checkCountCrossedCells(final int countCrossedCells) {
        if (countCrossedCells < 1) {
            throw new IllegalArgumentException("Expected to be a positive integer");
        } else if (countCrossedCells > xSize || countCrossedCells > ySize) {
            throw new IllegalArgumentException("The number of crossed out cells exceeds the size of the field");
        }
    }

    public int getCountCrossedCells() {
        return countCrossedCells;
    }

    void setCountCrossedCells(final int countCrossedCells) {
        checkCountCrossedCells(countCrossedCells);
        this.countCrossedCells = countCrossedCells;
    }

    void setxSize(int xSize) {
        this.xSize = xSize;
    }

    void setySize(int ySize) {
        this.ySize = ySize;
    }
}
