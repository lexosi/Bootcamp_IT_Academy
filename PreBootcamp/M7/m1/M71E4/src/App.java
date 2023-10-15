import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        float[] edges = new float[] {
            App.requestNumber(sc),
            App.requestNumber(sc),
            App.requestNumber(sc)
        };
        sc.close();

        String triangleType = App.getTriangleType(edges);
        System.out.println("Este triangulo es del tipo: " + triangleType);
    }

    public static float requestNumber(Scanner sc) {
        System.out.println("Introduce una variable");
        return sc.nextFloat();
    }

    public static String getTriangleType(float[] edges) {
        String message = "";
        if (edges[0] == edges[1] && edges[0] == edges[2]) {
            message = "Equilatero";
        }
        else if (edges[0] == edges[1] || edges[1] == edges[2] || edges[0] == edges[2]) {
            message = "Isosceles";
        }
        else {
            message = "Escaleno";
        }
        return message;
    } 
}
