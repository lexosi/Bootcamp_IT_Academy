package handler;

public class Car {
    private static final String BRAND = "Audi";
    private static String model;
    private final int POWER;
    
    public Car(int power) {
        this.POWER = power;
    }

    public static String getModel() {
        return Car.model;
    }

    public static void setModel(String model) {
        Car.model = model;
    }

    public static String getBrand() {
        return BRAND;
    }

    public int getPower() {
        return POWER;
    }

    public static void brake() {
        System.out.println("El coche està frenando.");
    }    
    
    public void acelerate() {
        System.out.println("El coche està acelerando.");
    }

    
}
