package handler.NPC;

import java.util.List;

import handler.AbstractNPC;
import handler.Item;

public class Mercader extends AbstractNPC {

    static int maxItems = 7;
            
        public Mercader(String nombre, String ciudad, List<Item> items, int maxItems) {
        super(nombre, ciudad, items, maxItems);
    }

        @Override
        public void agregarItem(Item item) {
            items.add(item);
        }
    
        @Override
        public void venderItem(Item item) {
            items.remove(item);
        }
    
        @Override
        public void comprarItem(Item item) {
            items.add(item);
        } 
    
}
