package core;

import sales.Sales;

public class Main {
    public static void main(String[] args) {
        int[] salesData = {250, 300, 280, 350};

        Sales s = new Sales();

        System.out.println("Average Sales = " + s.average(salesData));
        System.out.println("Maximum Sales = " + s.max(salesData));
        System.out.println("Minimum Sales = " + s.min(salesData));

        s.growth(salesData);
    }
}
