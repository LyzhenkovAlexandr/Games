package games;

public abstract class AbstractPlayer implements Player {
    protected String name;
    protected int age;
    protected Figure figure;

    protected AbstractPlayer(String name, int age, Figure figure) {
        if (age < 1) {
            throw new IllegalArgumentException("Incorrect age specified");
        }
        this.name = name;
        this.age = age;
        this.figure = figure;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Figure getFigure() {
        return figure;
    }
}
