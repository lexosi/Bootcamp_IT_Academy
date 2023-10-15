import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ahora escribe 3 números");
        List<Integer> numbers = App.parseNumbers(sc);
        sc.close();
        
        int maxNumber = Collections.max(numbers);
        int minNumber = Collections.min(numbers);
        System.out.println("El número mayor es: " + maxNumber);
        System.out.println("El número menor es: " + minNumber);
    }

    public static int[] requestNumbers(Scanner sc, int number) {
        int[] numbers = new int[number];
        
        for (int i = 0; i < number; i++){
            System.out.println("Escribe un número");
            numbers[i] = sc.nextInt();
        }
        return numbers;
    }

    public static List<Integer> parseNumbers(Scanner sc) {
        List<Integer> numbers = new ArrayList<>();
        
        for (int number : App.requestNumbers(sc, 3)) {
            if (numbers.contains(number)) {
                System.out.println("Hay un número repetido y es: " + number);
            }
            numbers.add(number);
        }
        return numbers;
    }
}

