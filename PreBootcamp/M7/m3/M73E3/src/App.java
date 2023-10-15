import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String word = App.getText(sc);
        sc.close();

        String reversedWord = App.reverseString(word);
        boolean palindrome = reversedWord.equalsIgnoreCase(word);
        String palindromeText = palindrome ? "es un palíndromo." : "no es un palíndromo.";
        System.out.println("Tu palabra " + palindromeText);
    }

    public static String getText(Scanner sc) {
        System.out.println("Dime la palabra que quieres que compruebe si es palíndromo");
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
