import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        float[] marks = App.requestFloats(sc, number);
        sc.close();

        float median = App.calculeMedian(marks);
        System.out.println(App.messageFromMedian(median));
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime cuantas notas deseas introducir");
        return sc.nextInt();
    }

    public static float[] requestFloats(Scanner sc, int number) {
        float[] numbers = new float[number];
        int i = 0;
        float input;
        while (i < number) {
            System.out.println("Escribe la nota número " + (i+1));
            input = sc.nextFloat();
            if (input < 0 || input > 10) {
                System.out.println("La nota introducida no es válida, di una nota entre 0 y 10 por favor.");
            } else {
                numbers[i] = input;
                i = i+1;    
            }
            
        }
        return numbers;
    }

    public static float calculeMedian(float[] numbers) {
        float sum = 0;
        for (float number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static String messageFromMedian(float median) {
        String message = "";
        if (median < 5) {
            message = "La nota mitjana de la classe està suspesa. Els/les alumnes haurien de preguntar els seus dubtes i treballar més";
        }
        else if (median < 7) {
            message = "La nota mitjana de la classe és bona, però els/les alumnes haurien de millorar el treball personal";
        }
        else{
            message = "Enhorabona! La nota mitjana de la classe es correspon amb l'esforç realitzat";
        } 
        return message;
    }

}
