package handler.screen.util;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUtil {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException _ignore) {}
    }

    public static void waitForUserInteraction(String message) {
        try {
            if (message != null) {
                System.out.print(message);
            }

            System.in.read();
        } catch (IOException exception) {
            exception.printStackTrace();
            System.exit(0);
        }
    }

    public static int requestInt(String question, int minValue, int maxValue) {
        
        int number = minValue - 1;
        do {
            System.out.print(question);
            number = ConsoleUtil.SCANNER.nextInt();
        } while (number < minValue || number > maxValue);
        
        return number;           
    }

    public static float requestFloat(String question, float minValue, float maxValue) {
        float number = minValue - 1;
        do {
            System.out.print(question);
            number = ConsoleUtil.SCANNER.nextFloat();
        } while (number < minValue || number > maxValue);
        
        return number;
    }

    public static double requestDouble(String question, double minValue, double maxValue) {
        double number = minValue - 1;
        do {
            System.out.print(question);
            number = ConsoleUtil.SCANNER.nextDouble();
        } while (number < minValue || number > maxValue);
        
        return number;
    }

    public static String requestString(String question) {
        String string = "";
        do {
            System.out.print(question);
            string = ConsoleUtil.SCANNER.next();
        } while (string.isBlank());
        
        return string;
    }

    public static String requestStringWithPattern(String question, String pattern) {
        String string = "";
        do {
            System.out.print(question);
            string = ConsoleUtil.SCANNER.next();

            if (!string.matches(pattern)) {
                System.out.println("No has introducido un valor válido.");
            }
        } while (string.isBlank() && !string.matches(pattern));
        
        return string;
    }
}
