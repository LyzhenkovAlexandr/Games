package games;

public abstract class AbstractRules {
    protected int xSize;
    protected int ySize;
    protected int countPlayers;

    public AbstractRules(int xSize, int ySize, int countPlayers) {
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
}
