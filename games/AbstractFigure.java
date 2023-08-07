package games;

public abstract class AbstractFigure implements Figure {
    protected final int minxSize;
    protected final int maxxSize;
    protected final int minySize;
    protected final int maxySize;
    protected final String turn;

    public AbstractFigure(int minxSize, int maxxSize, int minySize, int maxySize, String turn) {
        this.minxSize = minxSize;
        this.maxxSize = maxxSize;
        this.minySize = minySize;
        this.maxySize = maxySize;
        this.turn = turn;
    }

    @Override
    public int getMinxSize() {
        return minxSize;
    }

    @Override
    public int getMaxxSize() {
        return maxxSize;
    }

    @Override
    public int getMinySize() {
        return minySize;
    }

    @Override
    public int getMaxySize() {
        return maxySize;
    }

    @Override
    public String getTurn() {
        return turn;
    }
}
