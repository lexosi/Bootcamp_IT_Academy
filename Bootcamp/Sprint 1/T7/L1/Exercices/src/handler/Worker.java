package handler;

public class Worker {

    private String name;
    private String lastName;
    protected double priceHour;
    
    public Worker(String name, String lastName, double priceHour) {
        this.name = name;
        this.lastName = lastName;
        this.priceHour = priceHour;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPriceHour() {
        return this.priceHour;
    }

    public void setPriceHour(double priceHour) {
        this.priceHour = priceHour;
    }

    public double calculateWage(double workedHours) {
        return workedHours * this.priceHour;
    }
}
