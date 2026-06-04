package core;

import ecommerce.Clothing;
import ecommerce.Electronics;
import ecommerce.Grocery;
import ecommerce.Product;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Electronics(
                101,
                "Laptop",
                50000,
                2
        );

        Product p2 = new Clothing(
                102,
                "T-Shirt",
                2000,
                "L"
        );

        Product p3 = new Grocery(
                103,
                "Rice",
                1000,
                "12-12-2026"
        );

        p1.applyDiscount();
        p2.applyDiscount();
        p3.applyDiscount();

        System.out.println("\nElectronics:");
        p1.display();

        System.out.println("\nClothing:");
        p2.display();

        System.out.println("\nGrocery:");
        p3.display();
    }
}