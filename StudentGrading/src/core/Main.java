package core;

import student.InvalidMarksException;
import student.Student;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();

            System.out.print("Enter Marks 1: ");
            int m1 = sc.nextInt();

            System.out.print("Enter Marks 2: ");
            int m2 = sc.nextInt();

            System.out.print("Enter Marks 3: ");
            int m3 = sc.nextInt();

            Student student = new Student(name, roll, m1, m2, m3);

            System.out.println("\nStudent Details:");
            student.display();

        } catch (InvalidMarksException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
