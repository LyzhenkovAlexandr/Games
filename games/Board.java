package games;


public interface Board {
    Result makeMove(final Player player, final Move move);

    AbstractRules getRules();

    Figure[][] getField();

    void clearBoard();
}
