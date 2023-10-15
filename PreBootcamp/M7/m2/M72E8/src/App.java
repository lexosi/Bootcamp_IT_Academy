import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        sc.close();

        List<Integer> fibonacci = App.fibonacci(number);
        String value = fibonacci.stream()
            .map(n -> n.toString())
            .collect(Collectors.joining(", "));
        
        System.out.println("La serie de Fibonacci del número " + number + " es: " + value);
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime un número del que quieras saber la serie de Fibonacci");
        return sc.nextInt();
    }

    public static List<Integer> fibonacci(int number) {
        // f(n) = f(n-1) + f(n-2)
        // f(0) = 0
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        if (number <= 0) {
            return fibonacci;
        }

        fibonacci.add(1);

        for (int i = 2; i < number; i++) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
        }
        return fibonacci;
    }
}
