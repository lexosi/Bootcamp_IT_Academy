import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        /*Crea un programa que sol·liciti a l'usuari/ària quants noms desitja introduir.
        Una vegada tenim aquest número, demanarem a l'usuari/ària tants noms de persona com 
        ha dit prèviament i els emmagatzemarem en un ArrayList.
        Després, mostrarem per pantalla només els noms que comencen per la lletra “A”.
         */
        // Clase
        Scanner sc = new Scanner(System.in);

        // Variables
        int numNom;
        ArrayList<String> nombreArrayList = new ArrayList<String>();
        
        // Datos
        System.out.println("Dime cuantos nombres deseas introducir");
        numNom = sc.nextInt();
        
        for (int i=0; i<numNom; i++){
            System.out.println("Escribe el nombre nº"+(i+1));
            nombreArrayList.add(sc.next());
        }
        for (String nombre : nombreArrayList){
            if (nombre.toLowerCase().startsWith("a")){
                System.out.println(("Los nombres que empiezan por a son: ")+(nombre));

            }

        }

        }

    }

