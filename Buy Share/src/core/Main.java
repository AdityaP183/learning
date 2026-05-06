package core;

import stocks.GainCalculator;

public class Main {
    public static void main(String[] args) {
        int[] prices = {102, 105, 101, 110, 108, 115, 107};
        int buyPrice = 100;

        GainCalculator gc = new GainCalculator();

        int result = gc.maxGain(prices, buyPrice);

        System.out.println("Maximum Gain = " + result);
    }
}
