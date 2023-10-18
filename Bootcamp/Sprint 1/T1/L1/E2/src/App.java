import handler.Car;

public class App {
    public static void main(String[] args) throws Exception {
        final Car CAR01 = new Car(69);

        CAR01.acelerate();

        Car.brake();
    }
}
