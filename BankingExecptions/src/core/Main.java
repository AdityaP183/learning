package core;

import bank.BankAccount;
import bank.InsufficientBalanceException;

public class Main {
    static void main(String[] args) {
        BankAccount acc = new BankAccount(
            "ACC101",
            "Aditya",
            20000
        );

        System.out.println("\nInitial Details:");
        acc.display();

        System.out.println("\nAfter Deposit:");
        acc.deposit(5000);

        System.out.println("\nAfter Withdrawal:");
        try {
            acc.withdrawal(15000);
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nAfter Withdrawal:");
        try {
            acc.withdrawal(15000);
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }

    }
}
