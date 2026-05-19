package core;

import bank.SavingsAccount;

public class Main {

    public static void main(String[] args) {

        SavingsAccount acc = new SavingsAccount(
                "ACC101",
                "Aditya",
                "25000",
                "5"
        );

        System.out.println("Initial Details:");
        acc.display();

        System.out.println("\nAfter Deposit:");
        acc.deposit("5000");

        System.out.println("\nAfter Withdrawal:");
        acc.withdrawal("10000");

        System.out.println("\nInterest Calculation:");
        acc.calculateInterest();
    }
}