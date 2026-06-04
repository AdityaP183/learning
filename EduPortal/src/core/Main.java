package core;

import edu.portal.PostGraduateStudent;

public class Main {
    public static void main(String[] args) {
        PostGraduateStudent student =
                new PostGraduateStudent(
                        101,
                        "Aditya",
                        85,
                        90,
                        80,
                        "Artificial Intelligence"
                );

        System.out.println("Student Details:\n");

        student.display();

        student.displayResearchInfo();
    }
}