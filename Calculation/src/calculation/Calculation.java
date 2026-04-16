package calculation;

import java.math.BigInteger;

public class Calculation {
    public static BigInteger factorial(int n){
        if (n < 0){
            return BigInteger.valueOf(-1);
        }

        BigInteger fact = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        return fact;
    }

    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
