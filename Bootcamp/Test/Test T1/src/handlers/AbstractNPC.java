package handlers;

import java.util.List;

import ErrorMessage;
import ErrorMessage.InventoryFullException;

import package.Item;

public abstract class AbstractNPC {
    private static final int MAX_ITEMS = 0;
    private String category;
    private String location;
    private List<Item> items;

    public void addItem(Item item) throws ErrorMessage.InventoryFullException {
        if (this.items.size() >= MAX_ITEMS) {
            throw new InventoryFullException("[Inventario lleno!- El vendedor no puede comprar el ítem].");
        }
        this.items.add(item);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}