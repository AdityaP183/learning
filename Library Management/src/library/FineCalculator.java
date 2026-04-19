package library;

public class FineCalculator {
    public int calculateFine(int days) {

        if (days <= 0) return 0;

        if (days > 30) {
            return -1;
        }

        int fine = 0;

        if (days <= 5) {
            fine = days * 2;
        } else if (days <= 10) {
            fine = (5 * 2) + ((days - 5) * 3);
        } else {
            fine = (5 * 2) + (5 * 3) + ((days - 10) * 5);
        }

        return fine;
    }
}
