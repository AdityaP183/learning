package core;

import bank.Bank;

public class Main {
    public static void main(String[] args) {
        Bank B1 = new Bank("01634001300000452","Biman Sen", 'S', "55000");
        B1.display();
        System.out.println("\nAfter Depositing 35000 ...\n");
        B1.deposit("35000");
        B1.display();
        System.out.println("\nAfter Withdrawing 10000 ...\n");
        B1.withdraw("10000");
        B1.display();
    }
}
