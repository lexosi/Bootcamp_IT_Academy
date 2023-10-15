import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       /*Realitzar un programa que tingui un menú on se li mostraran 4 opcions a l’usuari/ària per pantalla:
            1.- Quadrat
            2.- Triangle
            3.- Rectangle
            4.- Cercle
            0.- Sortir del programa
            Segons l’opció escollida haurà d’introduir unes dades o altres perquè el programa mostri per pantalla 
            l’àrea (el valor) del polígon escollit.                 
        */
        Scanner sc = new Scanner(System.in);
        App.mainScreen(sc);
        sc.close();
    }

    public static void mainScreen(Scanner sc) throws IOException {
        App.clearScreen();
        System.out.println("Elige la opción que deseas realizar: ");
        System.out.println("1. Cuadrado");
        System.out.println("2. Triangulo");
        System.out.println("3. Rectangulo");
        System.out.println("4. Círculo");
        System.out.println("0. Sal del programa");

        int option = App.requestNumber(sc);
        if (option == 0) {
            System.exit(0);
            return;
        }
        App.polygonAreaScreen(sc, option);
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

    public static int requestNumber(Scanner sc) {
        int number = sc.nextInt();
        if (number < 0 || number > 4) {
            System.out.println("La opción escogida no es valida, dime otra:");
            return App.requestNumber(sc);
        }
        return number; 
    }

    public static void polygonAreaScreen(Scanner sc, int option) throws IOException {
        App.clearScreen();
        System.out.println("Introduce los siguientes parámetros (en centímetros):");
        
        float area = App.caculePolygonArea(option, App.requestPolygonValues(sc, option));
        System.out.println("El área del " + App.getPolygonType(option) + " es de " + area + " cm².");
        System.out.println("Pulsa cualquier tecla para volver al menú...");
        System.in.read();
        App.mainScreen(sc);
    }

    public static List<Float> requestPolygonValues(Scanner sc, int option) {
        List<Float> values = new ArrayList<Float>();
        switch(option) {
            case 1:
                System.out.println(" | Dime cuánto mide un lado del cuadrado");
                values.add(sc.nextFloat());
                break;
            case 2:
                System.out.println(" | Dime cuánto mide el alto del triangulo");
                values.add(sc.nextFloat());
                System.out.println(" | Dime cuánto mide el ancho del triangulo");
                values.add(sc.nextFloat());
                break;
            case 3:
                System.out.println(" | Dime cuánto mide el alto del rectángulo");
                values.add(sc.nextFloat());
                System.out.println(" | Dime cuánto mide el ancho del rectángulo");
                values.add(sc.nextFloat());
                break;
            case 4:
                System.out.println(" | Dime cuánto mide el rádio del círculo");
                values.add(sc.nextFloat());
                break;
            default: break;
        }
        return values;
    }

    public static float caculePolygonArea(int option, List<Float> values) {
        float area = 0.0F;
        float edge = values.get(0);
        switch(option) {
            case 1:
                area = edge*edge; 
                break;
            case 2:
                area = edge * values.get(1) /2;
                break;
            case 3:
                area = edge * values.get(1);
                break;
            case 4:
                area = (float) (Math.PI * (edge*edge));
                break;
            default: break;
        }
        return area;
    }

    public static String getPolygonType(int option) {
        switch(option) {
            case 1: return "cuadrado";
            case 2: return "triángulo";
            case 3: return "rectángulo";
            case 4: return "círculo";
            default: return "polígono";
        }
    }

   /* public static float caculePolygonArea2(int option, List<Float> values) {
        float edge = values.get(0);
        return switch(option) {
            case 1 -> edge*edge;
            case 2 -> edge * values.get(1) /2;
            case 3 -> edge * values.get(1);
            case 4 -> (float) (Math.PI * (edge*edge));
            default -> 0.0F;
        };
    }
    */
}
