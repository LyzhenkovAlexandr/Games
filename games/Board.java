package games;


public interface Board {
    Result makeMove(final Move move);

    void clearBoard();

    String draw();
}
