import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nombreArrayList = new ArrayList<String>();

        System.out.println("Dime cuantos nombres deseas introducir");
        int numNom = sc.nextInt();
        for (int i = 0; i < numNom; i++) {
            System.out.println("Escribe el nombre nº" + (i + 1));
            nombreArrayList.add(sc.next());
        }
        sc.close();

        System.out.println("Los nombres que contienen a son: ");

        for (String nombre : nombreArrayList) {
            if (nombre.toLowerCase().contains("a")) {
                System.out.println(nombre);
            }
        }
    }
}
