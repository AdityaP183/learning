package ecommerce;

public class Electronics extends Product {
    private int warranty;

    public Electronics(int productId, String name, double price, int warranty) {
        super(productId, name, price);
        this.warranty = warranty;
    }

    @Override
    public void applyDiscount() {
        price -= price * 0.10;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warranty: " + warranty + " years");
    }
}