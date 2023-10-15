package ejava;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static List<String> getMonth(){
        return new ArrayList<>() {
            {
                this.add("Enero");
                this.add("Febrero");
                this.add("Marzo");
                this.add("Abril");
                this.add("Mayo");
                this.add("Junio");
                this.add("Julio");
                this.add("Agosto");
                this.add("Septiembre");
                this.add("Octubre");
                this.add("Noviembre");
                this.add("Diciembre");
            }
        };
    }
    
    public static String getDniLetterByRest(int number) {
        return switch(number%23) {
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

    public static void throwError() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException(69);
    }
}
