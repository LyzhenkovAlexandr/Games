package games.ticTacToe;

import games.Board;
import games.Cell;
import games.Move;
import games.Result;

import java.util.Arrays;
import java.util.Map;

class TicTacToeBoard implements Board {
    private Cell[][] field;
    private final TicTacToeRules rules;
    private int countFreeCells;
    private Cell turn = Cell.X;
    private final Map<Cell, Character> CELL_TO_STRING = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    public TicTacToeBoard(TicTacToeRules rules) {
        this.rules = rules;
        this.field = new Cell[rules.getySize()][rules.getxSize()];
    }


    @Override
    public Result makeMove(Move move) {
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
    public String draw() {
        StringBuilder s = new StringBuilder("  ");
        for (int i = 1; i <= rules.getxSize(); i++) {
            s.append(i);
        }
        s.append("%n  ");
        for (int i = 0; i < rules.getxSize(); i++) {
            s.append('_');
        }
        s.append("%n");
        for (int r = 0; r < rules.getySize(); r++) {
            s.append(r + 1).append("|");
            for (int c = 0; c < rules.getxSize(); c++) {
                s.append(CELL_TO_STRING.get(field[r][c]));
            }
            s.append("%n");
        }
        return s.toString();
    }

    private Result checkWin() {
        for (int i = 0; i < rules.getxSize() - rules.getCountCrossedCells() + 1; i++) {
            for (int j = 0; j < rules.getySize() - rules.getCountCrossedCells() + 1; j++) {
                boolean win = true;
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
        if (countFreeCells == 0) {
            return Result.DRAW;
        }
        return Result.UNKNOWN;
    }
    // Pred: x > 0 && y > 0
    // Post: isValid move?

    private boolean isValid(Move move) {
        return 0 <= move.getRow() && move.getRow() < rules.getxSize() &&
                0 <= move.getCol() && move.getCol() < rules.getySize() &&
                field[move.getRow()][move.getCol()] == Cell.E;
    }

    void changeFieldSize() {
        field = new Cell[rules.getySize()][rules.getxSize()];
    }


}
