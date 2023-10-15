/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m3e3;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M3E3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          // Clase
        Scanner sc = new Scanner(System.in);
        
        //Variables
        int num1;
        int num2;
        int num3;
        double dividendo = 3;
        double resultado;
        
        //Datos
        System.out.println("Dime un número");
        num1 = sc.nextInt();
        System.out.println("Dime otro número");
        num2 = sc.nextInt();
        System.out.println("Dime otro número");
        num3 = sc.nextInt();
        resultado = ((num1+num2+num3)/dividendo);
        //Final
        System.out.println("La mitja total és: " + (resultado));
    }
    
}
