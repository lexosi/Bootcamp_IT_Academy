import java.io.IOException;
import java.util.Scanner;

public class App {    
    public static float CONVERSION_UNIT_YARD = 1.09361F;
    public static float CONVERSION_UNIT_FOOT = 3.281F;
    public static void main(String[] args) throws Exception {
        /*
        Crea un menú que permeti canviar d’unitats:
        Passar de metres a peus.
        De peus a metres.
        De metres a iardes.
        De iardes a metres
        */
        Scanner sc = new Scanner(System.in);
        App.mainScreen(sc);
        sc.close();
    }

    public static void mainScreen(Scanner sc) throws IOException {
        App.clearScreen();
        System.out.println("Elige la opción que deseas realizar: ");
        System.out.println("1. Pasar de metros de pies");
        System.out.println("2. Pasar de pies a metros");
        System.out.println("3. Pasar de metros a yardas");
        System.out.println("4. Pasar de yardas a metros");

        int option = App.requestNumber(sc);
        App.convertScreen(sc, option);
    }

    public static int requestNumber(Scanner sc) {
        int number = sc.nextInt();
        if (number < 1 || number > 4) {
            System.out.println("La opción escogida no es valida, dime otra:");
            return App.requestNumber(sc);
        }
        return number; 
    }

    public static String getInputUnit(int option) {
        switch(option) {
            case 2: return "pies";
            case 4: return "yardas";
            default: return "metros";
        }
    }

    public static String getOutputUnit(int option) {
        switch(option) {
            case 1: return "pies";
            case 3: return "yardas";
            default: return "metros";
        }
    }

    public static float performConvertion(int option, float value) {
        switch(option) {
            case 1: return value * App.CONVERSION_UNIT_FOOT;
            case 2: return value / App.CONVERSION_UNIT_FOOT;
            case 3: return value * App.CONVERSION_UNIT_YARD;
            case 4: return value / App.CONVERSION_UNIT_YARD;
            default: return value;
        }
    }

    public static void clearScreen(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public static void convertScreen(Scanner sc, int option) throws IOException {
        App.clearScreen();
        System.out.println("Introduce un número negativo si deseas volver al menú");
        System.out.println("Introduce el valor en " + App.getInputUnit(option));

        float value = sc.nextFloat();
        if (value < 0) {
            App.mainScreen(sc);
            return;
        }
        float result = App.performConvertion(option, value);
        System.out.println("El valor convertido de " + App.getInputUnit(option) + " a " + App.getOutputUnit(option) + " es: " + result);
        System.out.println("Pulsa cualquier tecla para volver al menú...");
        System.in.read();
        App.mainScreen(sc);
    }
}
