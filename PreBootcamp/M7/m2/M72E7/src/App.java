import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = App.requestNumber(sc);
        sc.close();

        boolean leap = App.isLeap(a);
        String leapMessage = leap ? " es bisiesto." : " no es bisiesto.";
        System.out.println("El año " + a + leapMessage);
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime un año");
        return sc.nextInt();
    }

    public static boolean isLeap(int year) {
        if(year%400 == 0) {
            return true;
        }
        if(year%4 == 0 && year%100 != 0) {
            return true;
        }
        return false;
    }
}
