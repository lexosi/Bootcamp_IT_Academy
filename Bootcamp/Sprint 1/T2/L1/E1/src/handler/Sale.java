package handler;

import java.util.List;

import handler.exception.EmptySaleException;

public class Sale {
    private final List<Product> LIST;
    private double totalPrice;
    
    public Sale(List<Product> list) {
        this.LIST = list;
        try {
            this.totalPrice = this.calculateTotalPrice();
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculateTotalPrice() throws EmptySaleException {
        if(this.LIST.size() == 0){
            throw new EmptySaleException();
        }
        return this.LIST.stream().mapToDouble(Product::getCost).sum();
    }

    public List<Product> getLIST() {
        return LIST;
    }

    public double getTotalPrice() {
        return totalPrice;
    }





}
