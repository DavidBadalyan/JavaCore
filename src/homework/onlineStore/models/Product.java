package homework.onlineStore.models;

import homework.onlineStore.enums.ProductType;

import java.util.UUID;

public class Product {
    private String ID;
    private String name;
    private String description;
    private double price;
    private int stockQty;
    private ProductType type;

    public Product() {
    }

    public Product(String name, String description, double price, int stockQty, ProductType type) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQty = stockQty;
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stockQty=" + stockQty +
                ", type=" + type +
                '}';
    }
}
