import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        sc.close();

        //// boolean ? valor_true : valor_false
        boolean isEven = number % 2 == 0;
        String evenMessage = isEven ? "par" : "impar";
        System.out.println("El número que has dicho es " + evenMessage + ".");
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Introduce un número");
        return sc.nextInt();
    }
}
