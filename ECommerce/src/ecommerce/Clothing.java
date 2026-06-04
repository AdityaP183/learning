package ecommerce;

public class Clothing extends Product {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public void applyDiscount() {
        price -= price * 0.20;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Size: " + size);
    }
}