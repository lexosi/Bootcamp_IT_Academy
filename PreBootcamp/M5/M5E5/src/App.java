import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*Los estudios lingüísticos modernos dicen que las palabras más bonitas de diccionario son aquellas que contienen 9 letras y comienzan 
        por la letra 'H', o bien, contienen 5 letras y comienzan por la letra 'P'.
        Haz un programa que pida palabras hasta que tengas tres palabras bonitas. Tienes que ir guardando las palabras bonitas en un array y 
        cuando tengas las tres, imprimirlas.
         */

        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        String word;

        System.out.println("Escribe tres palabras bonitas");
        while (list.size()<3){
            word = sc.next();
            if ((word.toLowerCase().startsWith("h") && word.length()==9) ||(word.toLowerCase().startsWith("p") && word.length()==5)){
                System.out.println("Esta palabra es bonita.");
                list.add(word);
            }
            if (list.size()<3){
                System.out.println("Escribe otra palabra");
            }
        }
        String wordFinal = String.join(" ", list);
        , 
        System.out.println("Las 3 palabras bonitas que has escrito son: " +wordFinal+".");
        sc.close();



    }
}
