package core;

import employee.Employee;
import employee.InvalidAgeException;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(name, age, salary);

            System.out.println("\nEmployee Details:");
            emp.display();

        } catch (InvalidAgeException e) {
            System.out.println(
                    "Exception: " + e.getMessage()
            );
        }
    }
}
