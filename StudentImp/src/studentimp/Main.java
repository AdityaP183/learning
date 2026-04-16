package studentimp;

import student.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Sutapa Sen", 25, 76, "2010");
        Student s2 = new Student("Amal Basu", 15, 85, "2010");
        Student s3 = new Student("Hitesh Bagchi", 31, 66, "2010");

        System.out.println(s1.display());
        System.out.println(s2.display());
        System.out.println(s3.display());

        Student[] students = {s1, s2, s3};

        Student topper = students[0];

        for (int i = 1; i < students.length; i++){
            if(students[i].getMarks() > topper.getMarks()){
                topper = students[i];
            }
        }

        System.out.println("\nTopper:");
        topper.displayRollName();
    }
}
