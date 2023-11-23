public class StockBroker implements Observer {
    private String name;

    public StockBroker(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("StockBroker " + name + " received: " + message);
    }
}
