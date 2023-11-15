package handler;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNPC {
    String nombre;
    String ciudad;
    protected List<Item> items = new ArrayList<>();
    protected static int maxItems = 0;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    protected abstract void agregarItem(Item item);
    protected abstract void venderItem(Item item);
    protected abstract void comprarItem(Item item);

    public void addItem(Item item) throws Exception {
        if (this.items.size() >= maxItems) {
            throw new Exception("[Inventario lleno!- El vendedor no puede comprar el ítem].");
        }
        this.items.add(item);
    }

    public AbstractNPC(String nombre, String ciudad, List<Item> items, int maxItems) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.items = items;
        AbstractNPC.maxItems = maxItems;
    }


}
