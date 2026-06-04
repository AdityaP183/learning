package core;

import lms.BorrowedBook;

public class Main {
    static void main(String[] args) {
        BorrowedBook b1 = new BorrowedBook(
                "1984",
                "George Orwell",
                150
        );

        System.out.println("Initial Details:");
        b1.displayDetails();

        System.out.println("\nBorrowing Book:");
        b1.borrowBook();
        b1.displayDetails();

        System.out.println("\nReturning Book:");
        b1.returnBook();
        b1.displayDetails();
    }
}
