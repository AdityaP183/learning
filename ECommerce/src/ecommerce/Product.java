package ecommerce;

public class Product {
    private int productId;
    private String name;
    protected double price;

    public Product(int productId, String name, double price) {

        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public void applyDiscount() {
    }

    public void display() {

        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: Rs. " + price);
    }
}