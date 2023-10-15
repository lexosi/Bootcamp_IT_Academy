package handler.products;

import handler.AbstractProduct;

public class Food extends AbstractProduct {

    public Food(int id, String name, float price, int stock, String description) {
        super(id, name, price, stock, description);    
    }
    
}
