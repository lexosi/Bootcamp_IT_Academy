import java.util.ArrayList;
import java.util.List;

import handler.Product;
import handler.Sale;

public class App {
    public static void main(String[] args) throws Exception {
        final List<Product> PRODUCTS = new ArrayList<>() {
                {
                    this.add(new Product("Product 1", 10));
                    this.add(new Product("Product 2", 20));
                }
            };

            new Sale(PRODUCTS);
    }
}
