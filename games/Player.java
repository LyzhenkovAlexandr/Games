package games;


public interface Player {
    Move move(final int xSize, final int ySize);

    void drawBoard(Board board);
    String getName();
    int getAge();
}
