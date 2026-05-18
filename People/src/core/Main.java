package core;

import mypackage.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Aditya", "1234-5678-9012", 25, "REG2026");

        System.out.println("\nStudent Details:");
        s1.display();
    }
}
