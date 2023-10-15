import handlers.Circle;
import handlers.Point;

public class App {
    public static void main(String[] args) throws Exception {
        Circle circle = new Circle(new Point(8, 3), 4);
        Circle circle2 = new Circle(new Point(2, 4), 9);

        System.out.println("El centro del primer círculo es: " + circle.getCenter() + 
            " el centro del segundo círculo es: " + circle2.getCenter());
        circle.setCenter(new Point(5, 0)); 
        circle2.setCenter(new Point(0, 1));
        System.out.println("El radio del primer círculo es de " + circle.getRadius() + 
            " el radio del segundo círculo es de " + circle2.getRadius());
        circle.setRadius(7);
        circle2.setRadius(12);
        System.out.println(circle.equals(circle2));
        System.out.println(circle.distanceBetweenCenter(circle2));
        System.out.println(circle.isConcentric(circle2));
        System.out.println(circle.hasSameRadius(circle2));
        System.out.println(circle.isTangent(circle2));
        System.out.println(circle.isIntersecting(circle2));
        System.out.println(circle.isOuter(circle2));
    }
}
