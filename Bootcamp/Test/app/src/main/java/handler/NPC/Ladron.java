package handler.NPC;

import java.util.List;

import org.checkerframework.checker.units.qual.m;

import handler.AbstractNPC;
import handler.Item;

public class Ladron extends AbstractNPC {
        
    static int maxItems = 3;
        public Ladron(String nombre, String ciudad, List<Item> items, int maxItems) {
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
