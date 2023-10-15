/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m4e6c;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M4E6C {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    
        // clase
        
        Scanner scanner = new Scanner(System.in);
                
        // impresión de información sobre los platos
        System.out.println("Bienvenidos al restaurante Fundamentos... nuestra carta para hoy: ");
        System.out.println("1. Carne");
        System.out.println("2. Pasta con un poco de gluten");
        System.out.println("3. Risotto con algo de lactosa");
        System.out.println("Ingrese el número de su preferencia: ");
     
        // variable, numero de plato       
        int plato = scanner.nextInt();
                
        // impresión de preferencias
        System.out.println("¿Tiene alguna preferencia o intolerancia?");
        System.out.println("1. es Vegano");
        System.out.println("2. Intolerante al gluten");
        System.out.println("3. Intolerante a la lactosa");
        System.out.println("4. Sin preferencias");
        System.out.println("Ingrese el número que corresponda: ");
       
        // variable preferencias           
        int preferencia = scanner.nextInt();
        
        // creamos la variable boolean puedeComer con el valor false
        boolean puedeComer = false;
        
        //creamos un conmutador para la variable platos
        //y lo combinamos con if else para descartar platos segun preferencias convitiendo la variable puedeComer en true
        //si las selecciones del cliente de plato y preferencia, encajan en los distintos conmutadores, ahora combinados.
        switch (plato) {               
            case 1: // Carne                   
                if (preferencia != 1) { //NO es Vegano
                    puedeComer = true;
                }
                break;
                        
            case 2: // Pasta con un poco de gluten                       
                if (preferencia != 2) { // NO Intolerante al gluten
                    puedeComer = true;
                }
                break;               
            
            case 3: // Risotto con algo de lactosa                       
                if (preferencia != 3) { // NO Intolerante a la lactosa
                    puedeComer = true;
                }
                break;
            default:
                    System.out.println("Plato inválido.");
                            System.exit(0);
                    }
        //finalmente, usamos otro if else para imprimir por consola, si de acuerdo a la elección, preferencia y/o
        //intoleancia, el cliente puede o no comer el plato seleccionado.
        if (puedeComer) {
                System.out.println("Perfecto, pedido correcto.");
        } else {
                 System.out.println("Lo sentimos, no deberia comer este plato.");
                }
 
                scanner.close();
            }
}// TODO code application logic here
    
    

