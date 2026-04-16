package core;

import bank.Bank;

public class Main {
    public static void main(String[] args) {
        Bank B1 = new Bank("01634001300000452","Biman Sen", 'S', "55000.67");
        B1.display();
        System.out.println("\nAfter Deposit ...\n");
        B1.deposit("45987.59");
        B1.display();
        System.out.println("\nAfter With draw ...\n");
        B1.withdraw("10000");
        B1.display();
    }
}
