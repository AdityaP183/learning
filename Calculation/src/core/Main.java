package core;

import calculation.Calculation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


//        1. Factorial
        System.out.print("Enter the number = ");
        int val = sc.nextInt();
        System.out.println("Factorial value for "+val +" = "+ Calculation.factorial(val));

//        2. Prime Number
        System.out.print("Enter the number = ");
        int prime_val = sc.nextInt();
        System.out.println(prime_val + (Calculation.isPrime(prime_val) ? " is a prime number" : " is not a prime number"));

//        3. GCD
        System.out.print("Enter the first number = ");
        int val1 = sc.nextInt();
        System.out.print("Enter the second number = ");
        int val2 = sc.nextInt();
        System.out.println("GCD of " + val1 + " and " + val2 + " = " + Calculation.gcd(val1, val2));

        sc.close();
    }
}
