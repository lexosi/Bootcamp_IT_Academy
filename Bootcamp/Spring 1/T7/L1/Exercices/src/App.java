import handler.OnlineWorker;
import handler.PresencialWorker;
import handler.Worker;

public class App {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        
        final Worker DEFAULT_WORKER = new Worker("Pepe", "Hernandez", 20);
        final OnlineWorker ONLINE_WORKER = new OnlineWorker("Raul", "Gamarra", 43);
        final PresencialWorker PRESENCIAL_WORKER = new PresencialWorker("Adam", "Casas", 31);
        
        System.out.println("DefaultWorker Hours: " + DEFAULT_WORKER.calculateWage(10));
        System.out.println("OnlineWorker Hours: " + ONLINE_WORKER.calculateWage(10));
        System.out.println("PresencialWorker Hours: " + PRESENCIAL_WORKER.calculateWage(10));
    }
}
