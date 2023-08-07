package games;

public abstract class AbstractRules {
    protected int xSize;
    protected int ySize;
    protected int countPlayers;
    protected int minxSize;
    protected int minySize;
    protected int minCountPlayers;
    protected int maxxSize;
    protected int maxySize;
    protected int maxCountPlayers;

    protected AbstractRules(int minxSize, int minySize, int minCountPlayers, int maxxSize, int maxySize, int maxCountPlayers) {
        this.minxSize = minxSize;
        this.minySize = minySize;
        this.minCountPlayers = minCountPlayers;
        this.maxxSize = maxxSize;
        this.maxySize = maxySize;
        this.maxCountPlayers = maxCountPlayers;
    }

    protected void setArguments(int xSize, int ySize, int countPlayers) {
        if (xSize < minxSize || ySize < minySize || xSize > maxxSize || ySize > maxySize) {
            throw new IllegalArgumentException("The field sizes must be positive integers and within the allowed values.");
        } else if (countPlayers < minCountPlayers || countPlayers > maxCountPlayers) {
            throw new IllegalArgumentException("The number of players must be within the allowed values");
        }
        this.xSize = xSize;
        this.ySize = ySize;
        this.countPlayers = countPlayers;
    }

    public String getInfo() {
        return "field length(x): " + xSize +
                "%nfield width(y): " + ySize +
                "%nrequired number of players: " + countPlayers;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getCountPlayers() {
        return countPlayers;
    }

    public int getMinxSize() {
        return minxSize;
    }

    public int getMinySize() {
        return minySize;
    }

    public int getMinCountPlayers() {
        return minCountPlayers;
    }

    public int getMaxxSize() {
        return maxxSize;
    }

    public int getMaxySize() {
        return maxySize;
    }

    public int getMaxCountPlayers() {
        return maxCountPlayers;
    }
}
