/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m3e2;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M3E2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Clase
        Scanner sc = new Scanner(System.in);
        
        //Variables
        int num1;
        int num2;
        
        //Datos
        System.out.println("Dime un número");
        num1 = sc.nextInt();
        System.out.println("Dime otro número");
        num2 = sc.nextInt();
        
        //Final
        System.out.println("El resultat de la suma és: " + (num1+num2));
        System.out.println("El resultat de la resta és: " + (num1-num2));
        System.out.println("El resultat de la multiplicació és: " + (num1*num2));
        System.out.println("El resultat de la divisió és: " + (num1/num2));
    }
    
}
