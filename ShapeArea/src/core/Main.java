package core;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Shape shape = null;

        System.out.println("Choose Shape:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();

                shape = new Circle(radius);
                break;

            case 2:
                System.out.print("Enter length: ");
                double length = sc.nextDouble();

                System.out.print("Enter width: ");
                double width = sc.nextDouble();

                shape = new Rectangle(length, width);
                break;

            case 3:
                System.out.print("Enter base: ");
                double base = sc.nextDouble();

                System.out.print("Enter height: ");
                double height = sc.nextDouble();

                shape = new Triangle(base, height);
                break;

            default:
                System.out.println("Invalid Choice");
                return;
        }

        System.out.println(
                "Area = " + shape.calculateArea()
        );
    }
}