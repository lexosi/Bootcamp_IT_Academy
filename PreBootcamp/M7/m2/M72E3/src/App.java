import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
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
        for (int i = 1; i < number; i++) {
            String line = "";
            for (int j = 1; j <= i; j++) {
                line += character;
            }
            System.out.println(line);
        }
        for (int i = number; i >= 1; i--) {
            String line = "";
            for (int j = 1; j <= i; j++) {
                line += character;
            }
            System.out.println(line);
        }
    }

}

