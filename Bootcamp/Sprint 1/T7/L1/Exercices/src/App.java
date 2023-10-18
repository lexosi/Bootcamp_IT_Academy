import handler.OnlineWorker;
import handler.PresencialWorker;
import handler.Worker;

public class App {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        
        Worker defaulWorker = new Worker("Pepe", "Hernandez", 20);
        OnlineWorker onlineWorker = new OnlineWorker("Raul", "Gamarra", 43);
        PresencialWorker presencialWorker = new PresencialWorker("Adam", "Casas", 31);
        
        System.out.println("DefaultWorker Hours: " + defaulWorker.calculateWage(10));
        System.out.println("OnlineWorker Hours: " + onlineWorker.calculateWage(10));
        System.out.println("PresencialWorker Hours: " + presencialWorker.calculateWage(10));
    }
}
