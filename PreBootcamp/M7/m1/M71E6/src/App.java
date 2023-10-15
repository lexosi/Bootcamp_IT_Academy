import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un número entre el 0 y el 10 y te diré su tabla de multiplicar");
        int number = App.requestNumber(sc);
        sc.close();

        App.printTable(number);        
    }

    public static int requestNumber(Scanner sc) {
        int number = sc.nextInt();
        if (number < 0 || number > 10) {
            System.out.println("El número que has introducido es incorecto, dime otro número que sea entre el 0 y el 10.");
            return App.requestNumber(sc);
        }
        return number; 
    }

    public static void printTable(int number) {
        System.out.println("La tabla del " + number + " es:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (i*number));
        }
    }
}
