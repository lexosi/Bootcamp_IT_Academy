import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = App.requestNumbers(sc);
        sc.close();

        int sumEven = numbers.stream()
            .filter(n -> App.isEven(n))
            .reduce((a,b) -> a+b)
            .orElse(0);
        int sumOdd = numbers.stream()
            .filter(n -> !App.isEven(n))
            .reduce((a,b) -> a+b)
            .orElse(0);

        System.out.println("La suma de los números pares es: " + sumEven);
        System.out.println("La suma de los números impares es: " + sumOdd);
    }

    public static List<Integer> requestNumbers(Scanner sc) {
        System.out.print("Introduce la cantidad de numeros que quieres utilizar: ");
        int numberAmount = sc.nextInt();
    
        List<Integer> numbers = new ArrayList<>();
    
        for (int i = 0; i < numberAmount; i++) {
            System.out.println("Introduce el numero " + (i + 1) + ":");
            numbers.add(sc.nextInt());
        }
        return numbers;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
