package handler;

public abstract class AbstractProduct {
    private final long ID;
    private final String NAME;

    private float price;
    private int stock;
    private int sail;
    private boolean garantee;
    private String description;
    
    public AbstractProduct(long id, String name, float price, int stock, int sail) {
        this.ID = id;
        this.NAME = name;
        this.price = price;
        this.stock = stock;
        this.sail = sail;
    }

    public AbstractProduct(long id, String name, float price, int stock, String description) {
        ID = id;
        NAME = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public AbstractProduct(long id, String name, float price, int stock, boolean garantee) {
        ID = id;
        NAME = name;
        this.price = price;
        this.stock = stock;
        this.garantee = garantee;
    }

    public long getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isGarantee() {
        return garantee;
    }

    public void setGarantee(boolean garantee) {
        this.garantee = garantee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSail() {
        return sail;
    }

    public void setSail(int sail) {
        this.sail = sail;
    }

    public double getCostPerUnit() {
        return this.price * (1 + (this.sail / 100));
    }
}
