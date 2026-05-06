package stocks;

public class BuySignal {

    public void findSignals(int[] prices) {

        double sum = prices[0]; // first day

        System.out.println("Day 1: No signal");

        for (int i = 1; i < prices.length; i++) {

            double avg = sum / i;

            if (prices[i] > prices[i - 1] && prices[i] > avg) {
                System.out.println("Day " + (i + 1) + ": Rs." + prices[i] + " BUY");
            } else {
                System.out.println("Day " + (i + 1) + ": No signal");
            }

            sum += prices[i];
        }
    }
}