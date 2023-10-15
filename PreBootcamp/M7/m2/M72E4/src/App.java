import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        sc.close();

        int factorial = App.obtainFactorial(number);
        System.out.println("El factorial del número " + number + " es: " + factorial + ".");
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime el número del que quieres saber el factorial");
        return sc.nextInt();
    }

    public static int obtainFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
