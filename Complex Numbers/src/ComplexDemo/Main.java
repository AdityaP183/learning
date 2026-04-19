package ComplexDemo;

import complex.Complex;

public class Main {
    public static void main(String[] args) {
        // Default constructor
        Complex c0 = new Complex();
        System.out.println("Default Complex: " + c0);

        // Parameterized constructor
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(4, 5);

        System.out.println("\nInitial Values:");
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);

        // Testing getters
        System.out.println("\nUsing Getters:");
        System.out.println("c1 Real: " + c1.getRealPart());
        System.out.println("c1 Imaginary: " + c1.getImaginaryPart());

        // Testing setters
        c0.setRealPart(1.5);
        c0.setImaginaryPart(2.5);
        System.out.println("\nAfter Setting c0:");
        System.out.println("c0: " + c0);

        // Arithmetic operations
        Complex sum = c1.add(c2);
        Complex diff = c1.subtract(c2);
        Complex prod = c1.multiply(c2);

        System.out.println("\nOperations:");
        System.out.println("Addition (c1 + c2): " + sum);
        System.out.println("Subtraction (c1 - c2): " + diff);
        System.out.println("Multiplication (c1 * c2): " + prod);
    }
}
