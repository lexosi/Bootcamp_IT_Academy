package handler;

public abstract class AbstractInstrument {

    protected double price;
    protected String name;

    public AbstractInstrument(double price, String name) {
        this.price = price;
        this.name = name;

    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public abstract void playMusic();

}
