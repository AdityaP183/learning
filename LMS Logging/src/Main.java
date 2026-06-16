import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BorrowerManager bm = new BorrowerManager();

        System.out.print("Enter Borrower ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Borrower Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Borrowed Book Name: ");
        String book = sc.nextLine();

        bm.addBorrower(id, name, book);

        System.out.println("\nDisplaying Borrower History...");
        bm.displayBorrowers();

        sc.close();
    }
}
