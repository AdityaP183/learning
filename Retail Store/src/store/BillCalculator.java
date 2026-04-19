package store;

public class BillCalculator {

    public double applyDiscount(double price, double rate) {
        return price - (price * rate);
    }

    public double calculateNetAmount(double price, String category) {

        double discountedPrice;

        if (category.equalsIgnoreCase("essential")) {

            if (price > 1000) {
                discountedPrice = applyDiscount(price, 0.10);
            } else {
                discountedPrice = price;
            }

            double tax = discountedPrice * 0.05;
            return discountedPrice + tax;
        } else if (category.equalsIgnoreCase("non-essential")) {

            if (price > 2000) {
                discountedPrice = applyDiscount(price, 0.15);
            } else {
                discountedPrice = price;
            }

            double tax = discountedPrice * 0.12;
            return discountedPrice + tax;
        } else {
            System.out.println("Invalid category");
            return -1;
        }
    }
}