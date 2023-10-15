import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
       /*Aquesta línia de codi:

        Math.ceil((Math.random() * 10)); 
        Retorna un número entre el 1 i el 10 de forma aleatòria.

        L’exercici consisteix a què l’usuari/ària ha d'endevinar el número escollit aleatòriament pel programa.

        El programa, demana números a l’usuari/ària fins que aquest encerti el número aleatori generat pel programa.

        Un cop l’usuari/ària ha endevinat el número, es mostrarà per pantalla el següent missatge: “Enhorabona, el número era X”
        
        */

        Scanner sc = new Scanner(System.in);

        //Variables
        int randomNumber = (int) Math.ceil((Math.random() * 10));
        int number;
        

        //Empezamos

        System.out.println("Ingresa un numero entre 0 y 10");
        number = sc.nextInt();
           
        while (number != randomNumber){
            System.out.println("El numero introducido no es el correcto. Elige otro:");
            number = sc.nextInt();
        }
        sc.close();
        System.out.println("Enorabuena, el número era: " + (number));
        }
    



        }
        ;
    

