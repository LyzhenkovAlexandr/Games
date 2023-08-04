package games;

import java.util.Arrays;
import java.util.Map;

public class TicTacToeBoard implements Board {
    private final Cell[][] field;
    private final int x;
    private final int y;
    private final int countCrossedCells;
    private int countFreeCells;
    private Cell turn = Cell.X;
    private Map<Cell, Character> CELL_TO_STRING = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    public TicTacToeBoard() {
        this.x = 3;
        this.y = 3;
        this.countCrossedCells = 3;
        this.countFreeCells = x * y;
        field = new Cell[y][x];
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

    private Result checkWin() {
        for (int i = 0; i < x - countCrossedCells + 1; i++) {
            for (int j = 0; j < y - countCrossedCells + 1; j++) {
                boolean win = true;
                for (int k = 0; k < countCrossedCells; k++) {
                    if (field[i][j + k] != turn) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return Result.WIN;
                }
                win = true;
                for (int k = 0; k < countCrossedCells; k++) {
                    if (field[i + k][j + k] != turn) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return Result.WIN;
                }
                win = true;
                for (int k = 0; k < countCrossedCells; k++) {
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
        return 0 <= move.getRow() && move.getRow() < x &&
                0 <= move.getCol() && move.getCol() < y &&
                field[move.getRow()][move.getCol()] == Cell.E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("  123\n +---\n");
        for (int r = 0; r < y; r++) {
            sb.append(r + 1).append("|");
            for (int c = 0; c < x; c++) {
                sb.append(CELL_TO_STRING.get(field[r][c]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
