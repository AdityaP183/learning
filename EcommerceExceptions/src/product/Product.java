package product;

public class Product {
    private final int productId;
    private final String productName;
    private int stock;

    public Product(int productId, String productName, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
    }

    public void purchase(int quantity) throws OutOfStockException {
        if (quantity > stock) {
            throw new OutOfStockException("Requested quantity exceeds available stock.");
        }

        stock -= quantity;

        System.out.println("Purchase Successful");
        System.out.println("Remaining Stock: " + stock);
    }

    public void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Stock: " + stock);
    }
}
