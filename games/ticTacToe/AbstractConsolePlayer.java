package games.ticTacToe;

import games.*;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

abstract class AbstractConsolePlayer extends AbstractPlayer {
    protected final Scanner in = new Scanner(System.in);
    protected final PrintStream out = System.out;
    private final Map<Cell, Character> CELL_TO_STRING = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    protected AbstractConsolePlayer(String name, int age) {
        super(name, age);
    }

    public void drawBoard(Board board) {
        AbstractRules rules = board.getRules();
        StringBuilder s = new StringBuilder("  ");
        for (int i = 1; i <= rules.getxSize(); i++) {
            s.append(i);
        }
        s.append("\n  ");
        s.append("_".repeat(Math.max(0, rules.getxSize())));
        s.append("\n");
        for (int r = 0; r < rules.getySize(); r++) {
            s.append(r + 1).append("|");
            for (int c = 0; c < rules.getxSize(); c++) {
                s.append(CELL_TO_STRING.get(board.getField()[r][c]));
            }
            s.append("\n");
        }
        out.println(s);
    }
}
