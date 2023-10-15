package handler.instruments;

import handler.AbstractInstrument;


public class Cuerda extends AbstractInstrument {

    public Cuerda(double price, String name) {
        super(price, name);

    }

    @Override
    public void playMusic() {
        System.out.println("Está sonando un instrumento de cuerda.");
    }
    
}
