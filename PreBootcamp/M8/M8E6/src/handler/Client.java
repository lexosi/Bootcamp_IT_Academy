package handler;

import java.util.List;

public class Client {
    private final String DNI;

    private String name;
    private List<Long> clientList;
    
    public Client(String dni, String name, List<Long> clientList) {
        this.DNI = dni;
        this.name = name;
        this.clientList = clientList;
    }

    public String getDNI() {
        return this.DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getClientList() {
        return clientList;
    }

    public void setClientList(List<Long> clientList) {
        this.clientList = clientList;
    }

    public void addProduct(AbstractProduct product) {
        final int PRODUCT_STOCK = product.getStock();
        if (PRODUCT_STOCK == 0) {
          return;
        }
        product.setStock(PRODUCT_STOCK - 1);
        this.clientList.add(product.getID());
    }

    public void removeProduct(AbstractProduct product) {
        if (this.clientList.remove(product.getID())) {
          product.setStock(product.getStock() + 1);
        }
    }
}
