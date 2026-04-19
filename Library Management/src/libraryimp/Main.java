package libraryimp;

import java.util.Scanner;
import library.FineCalculator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FineCalculator fc = new FineCalculator();

        System.out.print("Enter number of delayed days: ");
        int days = sc.nextInt();

        int fine = fc.calculateFine(days);

        if (fine != -1) {
            System.out.println("Total fine = Rs. " + fine);
        }else{
            System.out.println("Membership canceled.");
        }
    }
}
