package core;

import ems.Employee;
import ems.Manager;

public class Main {
    static void main(String[] args) {
        Employee e1 = new Employee(101, "Aditya", 30000);

        Manager m1 = new Manager(201, "Rahul", 50000, 10000);

        Employee e2 = new Employee(101, "Another", 40000);

        System.out.println("Employee Details:");
        System.out.println(e1);

        System.out.println("\nManager Details:");
        System.out.println(m1);

        System.out.println("\nSalary of Manager:");
        System.out.println("Rs. " + m1.calculateSalary());

        System.out.println("\nEquality Check:");
        System.out.println(e1.equals(e2));
    }
}
