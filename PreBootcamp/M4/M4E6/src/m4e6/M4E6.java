/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m4e6;

import java.util.Scanner;

/**
 *
 * @author lexos
 */
public class M4E6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea un programa per a un restaurant o tenen tres plats (carn, pasta “amb gluten” i risotto "amb lactosa").
        //El programa ha de demanar el plat que vol l'usuari/ària, però també ha de demanar si té cap preferència o intolerància (vegà, intolerància al gluten o intolerància a la lactosa).
        //Si la persona demana un plat "que pot menjar" mostrarem per consola el missatge "perfecte, comanda correcta", si no, es mostrarà el missatge "vostè no pot menjar aquest plat".
        Scanner sc = new Scanner(System.in);
        
        //Variables
       // Variables
boolean vegano = false;
boolean intGluten = false;
boolean intLactosa = false;

System.out.println("Si eres Vegano escribe 'vegano'; si tienes intolerancia al gluten escribe 'gluten', si eres intolerante a la lactosa escribe 'lactosa' y sino escribe 'no'");
String intolerancia = sc.next();

switch(intolerancia.toLowerCase()) {
  case "vegano":
    vegano = true;  
    System.out.println("Perfecto, eres de preferencia vegana.");
  break;
  case "gluten":
    intGluten = true; 
    System.out.println("Perfecto, eres intolerante al gluten."); 
  break;
  case "lactosa":
    intLactosa = true;
    System.out.println("Perfecto, eres intolerante a la lactosa.");
  break;
  default:
    System.out.println("No eres intolerante a nada.");
  break;
}

System.out.println("¿Qué quiéres escoger: carne, pasta o risotto?");
String comida = sc.next();

switch(comida.toLowerCase()) {
  // Dentro de los cases compruebo si puede comerlo o no
  case "carne":
    // Esto es una forma, metiendo el break dentro del if, asi ya lo de abajo no se ejecuta
    if (vegano) {
      System.out.println("No puedes comer esto si eres vegano.");
      break;
    }
    System.out.println("Perfecto, has pedido carne.");
  break;
  case "pasta":
    if (intGluten) {
      System.out.println("No puedes comer esto si eres intolerante al gluten.");
    } else {
      System.out.println("Perfecto, has pedido pasta.");
    }
  break;
  case "risotto":
    if (intLactosa) {
      System.out.println("No puedes comer esto si eres intolerante a la lactosa.");
    } else {
      System.out.println("Perfecto, has pedido un buen risotto.");
    }
  break;
  default:
  break;
}
}
        
    }
   

