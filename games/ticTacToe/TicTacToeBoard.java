package games.ticTacToe;

import games.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

// This class is responsible for the behavior of the board itself, all proposed changes are first checked for correctness
class TicTacToeBoard implements Board {
    private Cell[][] field;
    private final TicTacToeRules rules;
    private long countFreeCells;
    private Cell turn = Cell.X;

    public TicTacToeBoard(TicTacToeRules rules) {
        Objects.requireNonNull(rules);
        this.rules = rules;
        this.countFreeCells = (long) rules.getxSize() * rules.getySize();
        this.field = new Cell[rules.getySize()][rules.getxSize()];
    }


    @Override
    public Result makeMove(Move move) {
        Objects.requireNonNull(move);
        if (!isValid(move)) {
            return Result.LOSE;
        }
        field[move.getRow()][move.getCol()] = turn;
        countFreeCells--;
        Result res = checkWin();
        turn = turn == Cell.X ? Cell.O : Cell.X;
        return res;
    }

    @Override
    public void clearBoard() {
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
    }

    @Override
    public AbstractRules getRules() {
        return rules;
    }

    @Override
    public Cell[][] getField() {
        return field;
    }

    private Result checkWin() {
        for (int i = 0; i < rules.getySize(); i++) {
            for (int j = 0; j < rules.getxSize(); j++) {
                boolean win = true;
                if (j + rules.getCountCrossedCells() - 1 < rules.getxSize()) {
                    for (int k = 0; k < rules.getCountCrossedCells(); k++) {
                        if (field[i][j + k] != turn) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return Result.WIN;
                    }
                    win = true;
                }
                if (i + rules.getCountCrossedCells() - 1 < rules.getySize() && j + rules.getCountCrossedCells() - 1 < rules.getxSize()) {
                    for (int k = 0; k < rules.getCountCrossedCells(); k++) {
                        if (field[i + k][j + k] != turn) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return Result.WIN;
                    }
                    win = true;
                }
                if (i + rules.getCountCrossedCells() - 1 < rules.getySize()) {
                    for (int k = 0; k < rules.getCountCrossedCells(); k++) {
                        if (field[i + k][j] != turn) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return Result.WIN;
                    }
                }
            }
        }
        if (countFreeCells == 0) {
            return Result.DRAW;
        }
        return Result.UNKNOWN;
    }

    private boolean isValid(Move move) {
        return 0 <= move.getRow() && move.getRow() < rules.getySize() &&
                0 <= move.getCol() && move.getCol() < rules.getxSize() &&
                field[move.getRow()][move.getCol()] == Cell.E;
    }

    void updateFieldSize() {
        field = new Cell[rules.getySize()][rules.getxSize()];
        countFreeCells = (long) rules.getxSize() * rules.getySize();
    }
}
