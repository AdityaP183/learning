package gradingimp;

import java.util.Scanner;
import grading.GradeCalculator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeCalculator gc = new GradeCalculator();

        System.out.print("Enter marks of 1st subject: ");
        int m1 = sc.nextInt();
        System.out.print("Enter marks of 2nd subject: ");
        int m2 = sc.nextInt();
        System.out.print("Enter marks of 3rd subject: ");
        int m3 = sc.nextInt();

        if (!gc.isValid(m1, m2, m3)) {
            System.out.println("Invalid marks. Must be between 0 and 100.");
            return;
        }

        int total = gc.total(m1, m2, m3);
        double avg = gc.average(total);
        char grade = gc.getGrade(avg);

        System.out.println("Total = " + total);
        System.out.println("Average = " + avg);
        System.out.println("Grade = " + grade);
    }
}
