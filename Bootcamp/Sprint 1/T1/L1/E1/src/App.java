import handler.instruments.Cuerda;
import handler.instruments.Percusion;
import handler.instruments.Wind;

public class App {

    private static final Percusion PERCUSSION = new Percusion(524.99, "Drum");
    private static final Cuerda CUERDA = new Cuerda(799.99, "Guitar");
    private static final Wind WIND = new Wind(499.99, "Flute");

    public static void main(String[] args) throws Exception {
        App.PERCUSSION.playMusic();
        App.CUERDA.playMusic();
        App.WIND.playMusic();
    }
}
