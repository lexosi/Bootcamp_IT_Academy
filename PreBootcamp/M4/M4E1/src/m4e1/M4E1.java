/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m4e1;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M4E1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crea un programa que sol·liciti a l'usuari/ària que introdueixi dos nombres enters per teclat i mostri per pantalla el major dels dos.
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
        if (num1 > num2){
               System.out.println("El número más grandes es " + num1);
        }else if (num2 > num1){
           System.out.println("El número más grandes es " + num2);
        }else {
           System.out.print("Son el mismo número");}
    }
    }
