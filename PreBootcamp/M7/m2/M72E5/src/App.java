import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        sc.close();

        boolean prime = App.isPrime(number);
        String primeMessage = prime ? " es primo." : " no es primo.";
        System.out.println("El número " + number + primeMessage);
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime el número del que quieres saber si es primo o no");
        return sc.nextInt();
    }

    public static boolean isPrime(int number) {
        boolean prime = true;
        for (int i = 2; i <= number/2; i++) {
            if (number%i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
