package games.ticTacToe;

import games.*;
import games.figures.E;

import java.util.Arrays;
import java.util.Objects;

// This class is responsible for the behavior of the board itself, all proposed changes are first checked for correctness
class TicTacToeBoard implements Board {
    private Figure[][] field;
    private final TicTacToeRules rules;
    private long countFreeCells;
    private final Figure neutralFigure = new E();

    public TicTacToeBoard(TicTacToeRules rules) {
        Objects.requireNonNull(rules);
        this.rules = rules;
        this.countFreeCells = (long) rules.getxSize() * rules.getySize();
        this.field = new Figure[rules.getySize()][rules.getxSize()];
    }


    @Override
    public Result makeMove(final Player player, final Move move) {
        Objects.requireNonNull(move);
        if (!isValid(move)) {
            return Result.LOSE;
        }
        field[move.getRow()][move.getCol()] = player.getFigure();
        countFreeCells--;
        Result res = checkWin(player);
        return res;
    }

    @Override
    public void clearBoard() {
        for (Figure[] row : field) {
            Arrays.fill(row, neutralFigure);
        }
    }

    @Override
    public AbstractRules getRules() {
        return rules;
    }

    @Override
    public Figure[][] getField() {
        return field;
    }

    private Result checkWin(final Player player) {
        for (int i = 0; i < rules.getySize(); i++) {
            for (int j = 0; j < rules.getxSize(); j++) {
                boolean win = true;
                if (j + rules.getCountCrossedCells() - 1 < rules.getxSize()) {
                    for (int k = 0; k < rules.getCountCrossedCells(); k++) {
                        if (field[i][j + k].getClass() != player.getFigure().getClass()) {
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
                        if (field[i + k][j + k].getClass() != player.getFigure().getClass()) {
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
                        if (field[i + k][j].getClass() != player.getFigure().getClass()) {
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
                field[move.getRow()][move.getCol()].getClass() == neutralFigure.getClass();
    }

    void updateFieldSize() {
        field = new Figure[rules.getySize()][rules.getxSize()];
        countFreeCells = (long) rules.getxSize() * rules.getySize();
    }
}
