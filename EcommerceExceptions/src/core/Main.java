package core;

import product.OutOfStockException;
import product.Product;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p = new Product(101, "Laptop", 10);
        p.display();

        try {
            System.out.print("\nEnter quantity to purchase: ");

            int quantity = sc.nextInt();
            p.purchase(quantity);
        } catch (OutOfStockException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
