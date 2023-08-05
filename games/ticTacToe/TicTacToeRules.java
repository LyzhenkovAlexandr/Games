package games.ticTacToe;

import games.AbstractRules;

public class TicTacToeRules extends AbstractRules {
    private int countCrossedCells = 3;

    public TicTacToeRules() {
        super(3, 3, 2);
    }

    public TicTacToeRules(int xSize, int ySize, int countPlayers, int countCrossedCells) {
        super(xSize, ySize, countPlayers);
        this.countCrossedCells = countCrossedCells;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "required number of characters in a row to win: " + countCrossedCells;
    }

    public int getCountCrossedCells() {
        return countCrossedCells;
    }

    void setCountCrossedCells(int countCrossedCells) {
        this.countCrossedCells = countCrossedCells;
    }

    void setxSize(int xSize) {
        this.xSize = xSize;
    }

    void setySize(int ySize) {
        this.ySize = ySize;
    }
}
