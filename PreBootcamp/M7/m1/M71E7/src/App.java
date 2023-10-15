import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        char character = App.requestChar(sc);
        sc.close();

        App.printTable(character, number);
    }

    public static char requestChar(Scanner sc) {
        System.out.println("Dime un caràcter");
        return sc.next().charAt(0);
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime un número");
        return sc.nextInt();
    }

    public static void printTable(char character, int number) {
        String line = String.valueOf(character).repeat(number);
        System.out.println("Tu tabla queda así:");
        for (int i = 0; i < number; i++) {
            System.out.println(line);
        }
    }
}
