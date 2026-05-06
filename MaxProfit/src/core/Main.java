package core;

import stocks.MaxProfit;

public class Main {
    public static void main(String[] args) {
        int[] prices = {102, 105, 101, 110, 108, 115, 107};
        MaxProfit mp = new MaxProfit();

        int result = mp.maxProfit(prices);

        System.out.println("Maximum Profit = " + result);
    }
}
