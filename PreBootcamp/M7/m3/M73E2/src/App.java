import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String word = App.getText(sc);
        sc.close();

        System.out.println("Tu palabra escrita al revés es: " + App.reverseString(word));
    }

    public static String getText(Scanner sc) {
        System.out.println("Escribe la palabra que quieras que escriba al revés");
        return sc.next();
    }

    public static String reverseString(String word) {
        String reversed = "";
        for (int i = word.length()-1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        return reversed;
    }
}
