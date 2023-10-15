import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Clase
        Scanner sc = new Scanner(System.in);

        //Variables
        int num1;
        int num2;
        int resultado = 0;
        String resultadoString = "Suma: ";


        //Datos
        System.out.println("Dime un número");
        num1 = sc.nextInt();
        System.out.println("Dime otro número");
        num2 = sc.nextInt();

        if (num1 >= num2){
            System.out.println("Esta operación no es válida");
            sc.close();
            return;
        }
        for (int i = num1; i<=num2; i++){
            resultado += i;
            resultadoString +=i;
             if (i != num2) {
                resultadoString += " + ";
            }        
        }
        System.out.println(resultadoString+" = "+resultado);
        sc.close();
    }

}
