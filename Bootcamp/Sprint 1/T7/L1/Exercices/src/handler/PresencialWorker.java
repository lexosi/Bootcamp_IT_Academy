package handler;

@SuppressWarnings("removal")
public class PresencialWorker extends Worker {

    protected static final double FUEL_COST = new Double(10.0);

    public PresencialWorker(String name, String lastName, double priceHour) {
        super(name, lastName, priceHour);
    }

    @Override
    @Deprecated
    public double calculateWage(double workedHours) {
        return workedHours * this.getPriceHour() + PresencialWorker.FUEL_COST;
    }

}
