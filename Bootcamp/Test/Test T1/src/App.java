import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.google.gson.*;

import handlers.AbstractNPC;


public class App {
    public static void main(String[] args) {
        // implement logic to interact with the user
    }

    public static List<Item> getItemsFromSeller(AbstractNPC npc) {
        return npc.getItems();

    }

    public static List<AbstractNPC> getSellersInCity(String city) {
    List<AbstractNPC> sellersInCity = new ArrayList<>();
    for (AbstractNPC npc : allNPCs) {
        if (npc.getLocation().equals(city)) {
            sellersInCity.add(npc);
        }
    }
    return sellersInCity;
}
public static Item getCheapestItemInCity(String city) {
    List<AbstractNPC> sellersInCity = getSellersInCity(city);
    Item cheapestItem = null;

    for (AbstractNPC npc : sellersInCity) {
        for (Item item : npc.getItems()) {
            if (cheapestItem == null || item.getPrice() < cheapestItem.getPrice()) {
                cheapestItem = item;
            }
        }
    }

    return cheapestItem;
}

public static List<Item> getItemsOfTypeSortedByPrice(String type) {
    List<Item> itemsOfType = new ArrayList<>();

    for (AbstractNPC npc : allNPCs) {
        for (Item item : npc.getItems()) {
            if (item.getType().equals(type)) {
                itemsOfType.add(item);
            }
        }
    }

    itemsOfType.sort(Comparator.comparing(Item::getPrice));

    return itemsOfType;
}

public static void simulatePurchase(AbstractNPC npc, Item item) throws ItemNotFoundException {
 // TODO: add support for selling items
   
}

public static void simulateSale(AbstractNPC npc, Item item) throws InventoryFullException {
    npc.addItem(item);
 
}

public static void serializeNPCs() throws IOException {
    Gson gson = new Gson();
    String json = gson.toJson(allNPCs);
    Files.write(Paths.get("npcs.json"), json.getBytes());
}

}