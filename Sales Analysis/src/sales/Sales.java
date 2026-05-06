package sales;

public class Sales {
    public double average(int[] sales) {
        int sum = 0;
        for (int s : sales) {
            sum += s;
        }
        return sum / (double) sales.length;
    }

    public int max(int[] sales) {
        int max = sales[0];
        for (int s : sales) {
            if (s > max) max = s;
        }
        return max;
    }

    public int min(int[] sales) {
        int min = sales[0];
        for (int s : sales) {
            if (s < min) min = s;
        }
        return min;
    }

    public void growth(int[] sales) {
        System.out.println("\nGrowth Trend:");

        for (int i = 1; i < sales.length; i++) {
            if (sales[i] > sales[i - 1]) {
                System.out.println("Q" + (i + 1) + " : Positive Growth");
            } else {
                System.out.println("Q" + (i + 1) + " : Negative Growth");
            }
        }
    }
}
