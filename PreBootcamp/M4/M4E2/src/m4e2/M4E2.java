/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m4e2;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M4E2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea un programa que sol·liciti a l'usuari que introdueixi el seu nom i el nombre d'anys que porta treballant en una empresa per teclat i mostri per pantalla el seu nivell salarial, segons la següent taula:
            //Menys de 2 anys - 25.000 €
            //Entre 2 i 4 anys 35.000 €
            //Més de 4 i fins a 7 anys 50.000 €
            //Més de 7 i fins a 10 anys 65.000 €
            //Més de 10 anys 80.000 €
            
       // Clase
        Scanner sc = new Scanner(System.in);
        
        //Variables
        String nom;
        int tiempo;
        
        //Datos
        System.out.println("Cómo te llamas?");
        nom = sc.nextLine();
        System.out.println("Cuantos años llevas trabajando en la empresa?");
        tiempo = sc.nextInt();
                if (tiempo >= 10){
               System.out.println("Tu nivel salarial es 80.000€");
        }else if (tiempo >= 7){
               System.out.println("Tu nivel salarial es 65.000€");
        }else if (tiempo >= 4){
               System.out.println("Tu nivel salarial es 50.000€");
        }else if (tiempo >= 2){
               System.out.println("Tu nivel salarial es 35.000€");
        }else {
           System.out.print("Tu nivel salarial es 25.000€");}
    
    }
   }