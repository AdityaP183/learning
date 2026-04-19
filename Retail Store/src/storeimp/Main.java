package storeimp;

import store.BillCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BillCalculator bc = new BillCalculator();

        System.out.print("Enter product price: ");
        double price = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter category (essential/non-essential): ");
        String category = sc.nextLine();

        double result = bc.calculateNetAmount(price, category);

        if (result != -1) {
            System.out.println("Net amount to pay = Rs. " + result);
        }
    }
}