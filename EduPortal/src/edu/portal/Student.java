package edu.portal;

public class Student {
    private int studentId;
    private String name;

    private int marks1;
    private int marks2;
    private int marks3;

    public Student(int studentId, String name, int marks1, int marks2, int marks3) {
        this.studentId = studentId;
        this.name = name;

        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public int calculateTotal() {
        return marks1 + marks2 + marks3;
    }

    public String calculateGrade() {
        double avg = calculateTotal() / 3.0;

        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else return "D";
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);

        System.out.println("Total Marks: " + calculateTotal());

        System.out.println("Grade: " + calculateGrade());
    }
}
