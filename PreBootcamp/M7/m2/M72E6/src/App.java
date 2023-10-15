import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);

        while(!App.isPrime(number)) {
            number = App.requestNumber(sc);
        }

        sc.close();
        System.out.println("Exacte, el número " + number + " és primer.");
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime un número");
        return sc.nextInt();
    }

    public static boolean isPrime(int number) {
        boolean prime = true;
        int i=2;
        while (i <= number/2 && prime) {
            if (number%i == 0) {
                prime = false;
            }
            i++;
        }
        return prime;
    }
}


