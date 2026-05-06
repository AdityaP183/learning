package core;

import stocks.BuySignal;

public class Main {
    public static void main(String[] args) {
        int[] prices = {210, 215, 212, 220, 225, 223, 230};

        BuySignal bs = new BuySignal();
        bs.findSignals(prices);
    }
}
