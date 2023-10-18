package handler.instruments;

import handler.AbstractInstrument;


public class Percusion extends AbstractInstrument {

    public Percusion(double price, String name) {
        super(price, name);

    }

    @Override
    public void playMusic() {
        System.out.println("Está sonando un instrumento de percusión.");
    }
    
}
