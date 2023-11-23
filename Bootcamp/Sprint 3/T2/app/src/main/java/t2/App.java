package t2;

import main.java.t2.StockBroker;
import main.java.t2.StockMarket;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
         StockMarket stockMarket = new StockMarket();

        StockBroker broker1 = new StockBroker("Broker 1");
        StockBroker broker2 = new StockBroker("Broker 2");

        stockMarket.addObserver(broker1);
        stockMarket.addObserver(broker2);

        stockMarket.marketUp();
        stockMarket.marketDown();
    }
    }

