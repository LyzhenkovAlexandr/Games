package games;

import games.ticTacToe.TicTacToeRules;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractBoard implements Board {
    protected Figure[][] field;
    protected final TicTacToeRules rules;
    protected final Figure neutralFigure;

    public AbstractBoard(Figure[][] field, TicTacToeRules rules, Figure neutralFigure) {
        Objects.requireNonNull(rules);
        Objects.requireNonNull(field);
        Objects.requireNonNull(neutralFigure);
        this.field = field;
        this.rules = rules;
        this.neutralFigure = neutralFigure;
    }

    @Override
    public AbstractRules getRules() {
        return rules;
    }

    @Override
    public Figure[][] getField() {
        return field;
    }

    @Override
    public void clearBoard() {
        for (Figure[] row : field) {
            Arrays.fill(row, neutralFigure);
        }
    }
}
