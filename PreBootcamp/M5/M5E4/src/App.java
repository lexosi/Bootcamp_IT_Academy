import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    /*Fes un programa que demani per consola quants nens i nenes volem introduir per fer una reserva d'una actuació de titelles.

    Un cop sabem el nombre de nens i nenes has de demanar les seves edats. Les edats només poden estar compreses entre 5 i 12 anys,
    per tant, si en demanar una edat, l'usuari/ària introdueix una que no està en aquest rang, li has de tornar a demanar (fins que introdueixi una correcta).

    Finalment, has de mostrar per pantalla la mitjana d'edats dels nens.
    */
     Scanner sc = new Scanner(System.in);

     //Variables
     int audience;
     boolean ageBetween = false;
     int age = 0;
     ArrayList<Integer> ageArrayList = new ArrayList<Integer>();
    ageBetween = (age >=5 && 12<= age) ? true : false ;



     //Empezamos
     System.out.println("Para cuantos niños y niñas quiere hacer la reserva?");
        audience = sc.nextInt();

     System.out.println("Ahora me has de decir la edad de cada uno de los asistentes");
    
    for (int i = 0; i<audience; i++){
        System.out.println("Que edad tiene el niño o la niña? nº" +i);
        age = sc.nextInt();
        while ()

    }


    }
}
