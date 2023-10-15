import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int number = App.requestNumber(sc);
        String[] names = App.requestNames(sc, number);
        sc.close();

        App.printNames(names);
    }

    public static int requestNumber(Scanner sc) {
        System.out.println("Dime cuantos nombres deseas introducir");
        return sc.nextInt();
    }

    public static String[] requestNames(Scanner sc, int number) {
        String[] names = new String[number];
        
        for (int i = 0; i < number; i++){
            System.out.println("Escribe el nombre nº"+(i+1));
            names[i] = sc.next();
        }
        return names;    
    }
    
    public static void printNames(String[] names) {
        System.out.println("Los nombres que empiezan por a son: ");
        for (String name : names){
            if (name.toLowerCase().startsWith("a")){
                System.out.println(name);
            }
        }
    }
}