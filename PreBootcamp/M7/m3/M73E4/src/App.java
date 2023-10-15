import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String dni = App.getDni(sc);
        sc.close();

        if (dni == null) {
            System.out.println("El dni introducido no es válido");
            return;
        }
        int restDni = App.checkDni(dni);
        String letterDni = String.valueOf(dni.charAt(8));
        String correctLetter = App.getDniLetterByRest(restDni);
        boolean isCorrect = letterDni.equalsIgnoreCase(correctLetter);
        String dniMessage = isCorrect ? "correcto." : "incorrecto. La letra correcta es: " + correctLetter;

        System.out.println("El dni que nos has dado es " + dniMessage);

    }

    public static String getDni(Scanner sc) {
        System.out.println("Dime tú número de DNI con la letra incluida y sin ningún espacio en blanco");
        String dni = sc.next();

        if (!dni.toUpperCase().matches("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$")) {
            return null;
        }
        return dni;
    }

    public static int checkDni(String dni) {
        String numbersDni = dni.substring(0, 8);
        int numbers = Integer.parseInt(numbersDni);
        return numbers % 23;
    }

    public static String getDniLetterByRest(int rest) {
        return switch(rest) {
            case 0 -> "T";
            case 1 -> "R";
            case 2 -> "W";
            case 3 -> "A";
            case 4 -> "G";
            case 5 -> "M";
            case 6 -> "Y";
            case 7 -> "F";
            case 8 -> "P";
            case 9 -> "D";
            case 10 -> "X";
            case 11 -> "B";
            case 12 -> "N";
            case 13 -> "J";
            case 14 -> "Z";
            case 15 -> "S";
            case 16 -> "Q";
            case 17 -> "V";
            case 18 -> "H";
            case 19 -> "L";
            case 20 -> "C";
            case 21 -> "K";
            case 22 -> "E";
            default -> "?";
        };
    }
}
