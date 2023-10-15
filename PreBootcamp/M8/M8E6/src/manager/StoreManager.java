package manager;

import java.util.ArrayList;
import java.util.List;

import handler.AbstractProduct;
import handler.products.*;

public class StoreManager {
    
    private static final List<AbstractProduct> PRODUCT = new ArrayList<>();

    public static boolean containsProduct(long id) {
        return StoreManager.PRODUCT.stream()
        .anyMatch(product -> product.getID() == id);
    }

    public static void addProduct(AbstractProduct product) {
        if (StoreManager.containsProduct(product.getID())) {
            StoreManager.removeProduct(product.getID());
        }
        StoreManager.PRODUCT.add(product);    
    }

    public static boolean removeProduct(long id) {
        return StoreManager.PRODUCT.removeIf(product -> product.getID() == id);
    }

    public static AbstractProduct getProduct(long id) {
        AbstractProduct product = null;
        int index = 0;

        while (index < StoreManager.PRODUCT.size() && product == null) {
            AbstractProduct p = StoreManager.PRODUCT.get(index);
            if (p.getID() == id) {
                product = p;            
            }
            index++;
        }
        return product;
    }

    public static Clothes createClothes(int id, String name, float price, int stock, int sail) {
        Clothes product = new Clothes(id, name, price, stock, sail);
        StoreManager.addProduct(product);
        return product;
    }

    public static Electronics createElectronics(int id, String name, float price, int stock, boolean garantee) {
        Electronics product = new Electronics(id, name, price, stock, garantee);
        StoreManager.addProduct(product);
        return product;
    }

     public static Food createFodd(int id, String name, float price, int stock, String description) {
        Food product = new Food(id, name, price, stock, description);
        StoreManager.addProduct(product);
        return product;
    }

    public static int productType(AbstractProduct product) {
        int type = 0;

        if (product instanceof Clothes) {
            type = 1;
        } else if (product instanceof Electronics) {
            type = 2;
        } else if (product instanceof Food) {
            type = 3;
        }
        return type;
    }
}

