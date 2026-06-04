package ecommerce;

public class Grocery extends Product {
    private String expiryDate;

    public Grocery(int productId, String name, double price, String expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void applyDiscount() {
        price -= price * 0.05;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Expiry Date: " + expiryDate);
    }
}