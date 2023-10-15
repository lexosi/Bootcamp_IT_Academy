package handler;

/* 
    all : ignora todos los warnings
    deprecation : ignora los warns de deprecación
    removal : ignora los avisos por eliminación próxima del método
    unchecked : ignora avisos de cambio de tipo de objetos
    unused : evita los warnings por no usar variables declaradas
*/
@SuppressWarnings("removal")
public class OnlineWorker extends Worker {

    protected static final double INTERNET = new Double(20.0);

    public OnlineWorker(String name, String lastName, double priceHour) {
        super(name, lastName, priceHour);
    }

    @Override
    @Deprecated
    public double calculateWage(double workedHours) {
        return workedHours * this.getPriceHour() + OnlineWorker.INTERNET;
    }
}
