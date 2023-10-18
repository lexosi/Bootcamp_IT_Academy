package handler.instruments;

import handler.AbstractInstrument;


public class Wind extends AbstractInstrument {

    public Wind(double price, String name) {
        super(price, name);

    }

    @Override
    public void playMusic() {
        System.out.println("Está sonando un instrumento de viento.");

    }
    
}
