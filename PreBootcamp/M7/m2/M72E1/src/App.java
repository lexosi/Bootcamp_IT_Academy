import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       /*Fes un programa que mostri el següent per pantalla:
            *
            * *
            * * *
            * * * *
            * * * * *
            * * * * * *

            El nombre de línies formades per “*” vindrà donat per un número que l’usuari/ària introduirà
            per consola.
            Condició: En tot el codi del programa només hi pot haver un *
            També, a poder ser, no utilitzis cap mètode com repeat() o substring() de la classe String.
        */
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        sc.close();

        App.printText(number, "* ");
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime cuantas líneas deseas introducir");
        return sc.nextInt();
    }

    public static void printText(int number, String character) {
        for (int i = 1; i <= number; i++) {
            String line = "";
            for (int j = 1; j <= i; j++) {
                line += character;
            }
            System.out.println(line);
        }
    }
}
