package handler;

public class Product {

  private final String NAME;
  private final double COST;

  public Product(String name, double cost) {
    this.NAME = name;
    this.COST = cost;
  }

  public String getName() {
    return this.NAME;
  }

  public double getCost() {
    return this.COST;
  }
}