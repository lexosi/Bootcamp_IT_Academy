package manager;

import java.util.ArrayList;
import java.util.List;

import handler.Client;

public class ClientManager {
    
    private static final List<Client> CLIENT = new ArrayList<>();
    
    public static boolean containsClient(String dni) {
        return ClientManager.CLIENT.stream()
            .anyMatch(client -> client.getDNI() == dni);
    }
    
    public static void addClient(Client client) {
        if (ClientManager.containsClient(client.getDNI())) {
            ClientManager.removeClient(client.getDNI());
        }
        ClientManager.CLIENT.add(client);
    }

    public static boolean removeClient(String dni) {
        return ClientManager.CLIENT.removeIf(client -> client.getDNI() == dni);
    }

    public static Client getClient(String dni) {
        Client client = null;
        int index = 0;

        while (index < ClientManager.CLIENT.size() && client == null) {            
            Client c = ClientManager.CLIENT.get(index);
            if (c.getDNI() == dni) {                
                client = c;
            }
            index++;
        }
        return client;
    }
}
