/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m4e5;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M4E5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Fer un programa que demani dos números i un operador(+,-,*,/).
        //Al final, el programa ha d'imprimir per pantalla el resultat de fer l’operació que contingui la variable operador.
         // Clase
        Scanner sc = new Scanner(System.in);
        
        //Variables
        float num1;
        float num2;
        char operador;
        float resultado;
        
        //Datos
        System.out.println("Dime un número");
        num1 = sc.nextInt();
        System.out.println("Dime otro número");
        num2 = sc.nextInt();
        System.out.println("Dime un operador entre (+,-,*,/)");
        operador = sc.next().charAt(0);
        
        switch (operador) {
            case '+':
            resultado = num1 + num2;
            break;
            case '-':
            resultado = num1 - num2;
            break;
            case '*':
            resultado = num1 * num2;
            break;
            case '/':
            resultado = num1 / num2;
            break;
            default:
            System.out.println("Operación no válida");
            resultado = 0;
            break;

                       
        }
        System.out.println("El resultado es: " + resultado);
        }
    }
    

