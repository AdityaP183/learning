package core;

import staff.MathTeacher;
import staff.Teacher;

public class Main {
    public static void main(String[] args) {
                Teacher t = new MathTeacher(
                        "Aditya",
                        "MAKAUT",
                        "Algebra"
                );

                System.out.println("\nTeacher Details:");
                t.display();
    }
}
