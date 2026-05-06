package stocks;

public class GainCalculator {
    public int maxGain(int[] prices, int buyPrice) {
        int maxGain = 0;

        for (int price : prices) {
            int gain = price - buyPrice;

            if (gain > maxGain) {
                maxGain = gain;
            }
        }

        return maxGain;
    }
}
