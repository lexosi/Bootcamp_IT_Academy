/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m4e4;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M4E4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea un programa que sol·liciti a l'usuari/ària que introdueixi un número de l'1 al 10 i mostri per pantalla el seu equivalent en lletres (per exemple, 1 es mostraria com "u", 2 com "dos", etc.).
          // Clase
        Scanner sc = new Scanner(System.in);
        
        //Variables
        int num;
        String letra;
        
        System.out.println("Dime un número del 1 al 10");
        num = sc.nextInt();
        switch (num) {
            case 1: letra=("a");
            break;
            case 2: letra=("b");
            break;
            case 3: letra=("c");
            break;
            case 4: letra=("d");
            break;
            case 5: letra=("e");
            break;
            case 6: letra=("f");
            break;
            case 7: letra=("g");
            break;
            case 8: letra=("h");
            break;
            case 9: letra=("i");
            break;
            case 10: letra=("j");
            break;
            default: letra=("inválido");
            break;
        }
        System.out.println("El valor del número que has escogido en letras es: " + letra);
        
    }
    
}
