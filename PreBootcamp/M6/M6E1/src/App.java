import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        float[] numbers = App.requestNumber(sc);
        char operator = App.requestOperator(sc);
        sc.close();

        Float result = App.result(numbers, operator);
        if (result != null){
            System.out.println("El resultado es: " + result);
        }
    }

    public static float[] requestNumber(Scanner sc) {
        float[] numbers = new float[2];

        System.out.println("Dime un número");
        numbers[0] = sc.nextFloat();
        System.out.println("Dime otro número");
        numbers[1] = sc.nextFloat();
        
        return numbers;
    }

    public static char requestOperator(Scanner sc) {
        System.out.println("Dime un operador entre (+,-,*,/)");
        return sc.next().charAt(0);
    }

    public static Float result(float[] numbers, char operator) {
        float resultado = 0;
        if(numbers.length <2) {
            System.out.println("No tienes suficientes números para realizar la operación.");
         //   return null; //solo un return por metodo y al final del todo
         
        } else{
            float num1 = numbers[0];
            float num2 = numbers[1];

            switch (operator) {
            case '+': resultado = sum(num1, num2);
            case '-': resultado = minus(num1, num2);
            case '*': resultado = plus(num1, num2);
            case '/': resultado = divide(num1, num2);
            default:
            System.out.println("Operación no válida");                
            } 
        }
        return resultado;
        
    }
    
    public static float sum(float num1, float num2) {
        return num1 + num2;
    }

    public static float minus(float num1, float num2) {
        return num1 - num2;
    }    

    public static float plus(float num1, float num2) {
        return num1 * num2;
    }

    public static float divide(float num1, float num2) {
        return num1 / num2;
    }
}
