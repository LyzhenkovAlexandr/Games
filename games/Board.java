package games;


public interface Board {
    Result makeMove(final Move move);

    AbstractRules getRules();

    Cell[][] getField();

    void clearBoard();
}
