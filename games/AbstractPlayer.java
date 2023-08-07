package games;

public abstract class AbstractPlayer implements Player {
    protected String name;
    protected int age;

    protected AbstractPlayer(String name, int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Incorrect age specified");
        }
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
