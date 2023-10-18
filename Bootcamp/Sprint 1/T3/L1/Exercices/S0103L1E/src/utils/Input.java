package utils;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private static final Scanner SCANNER = new Scanner(System.in, "UTF-8");

    public static String normalizeString(String input) throws UnsupportedEncodingException {
        final String S1 = Normalizer.normalize(input, Normalizer.Form.NFD);
        return S1
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static void waitUserInput() {
        Input.SCANNER.nextLine();
    }

    public static byte readByte(String prompt) {
        System.out.println(prompt);

        byte value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                value = SCANNER.nextByte();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid byte.");

                /*
                 * Limpia el búfer de entrada para evitar bucles
                 * infinitos en caso de error de entrada.
                 */
                SCANNER.nextLine();
            }
        }

        return value;
    }

    public static int readInt(String prompt) {
        System.out.println(prompt);

        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                value = SCANNER.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer number.");
                SCANNER.nextLine();
            }
        }

        return value;
    }

    public static float readFloat(String prompt) {
        System.out.println(prompt);

        float value = 0.0f;
        boolean valid = false;

        while (!valid) {
            try {
                value = SCANNER.nextFloat();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid decimal number.");
                SCANNER.nextLine();
            }
        }

        return value;
    }

    public static double readDouble(String prompt) {
        System.out.println(prompt);

        double value = 0.0;
        boolean valid = false;

        while (!valid) {
            try {
                value = SCANNER.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid decimal number.");
                SCANNER.nextLine();
            }
        }

        return value;
    }

    public static String readString(String prompt) {
        System.out.println(prompt);

        String value = "";
        boolean valid = false;

        while (!valid) {
            try {
                final String INPUT = System.console().readLine();
                if (INPUT.isEmpty()) {
                    throw new Exception();
                }
                value = INPUT;
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid string.");
                SCANNER.nextLine();
            }
        }

        return value;
    }

    public static char readChar(String prompt) {
        System.out.println(prompt);

        char value = ' ';
        boolean valid = false;

        while (!valid) {
            try {
                value = SCANNER.next().charAt(0);
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid character.");
                SCANNER.nextLine();
            }
        }

        return value;
    }

    public static boolean readBoolean(String prompt) {
        System.out.println(prompt);

        boolean value = false;
        boolean valid = false;

        while (!valid) {
            try {
                value = SCANNER.nextBoolean();
                valid = true;
            } catch (Exception e) {

                final String INPUT = SCANNER.nextLine();

                if (INPUT.toLowerCase().startsWith("y")
                        || INPUT.toLowerCase().startsWith("s")) {
                    value = true;
                    valid = true;
                } else if (INPUT.toLowerCase().startsWith("n")) {
                    value = false;
                    valid = true;
                } else {
                    System.out.println("Please enter a valid boolean.");
                    SCANNER.nextLine();
                }
            }
        }

        return value;
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
