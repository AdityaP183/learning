package lms;

public class BorrowedBook extends Book implements Borrowable{
    private boolean isBorrowed;

    public BorrowedBook(String title, String author, double price) {
        super(title, author, price);

        this.isBorrowed = false;
    }

    @Override
    public void borrowBook() {

        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    @Override
    public void returnBook() {

        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Status: " + (isBorrowed ? "Borrowed" : "Available"));
    }
}
