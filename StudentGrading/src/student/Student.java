package student;

public class Student {
    private final String name;
    private final int rollNumber;
    private final int marks1;
    private final int marks2;
    private final int marks3;

    public Student(
            String name, int rollNumber, int marks1, int marks2, int marks3
    ) throws InvalidMarksException {
        validateMarks(marks1);
        validateMarks(marks2);
        validateMarks(marks3);

        this.name = name;
        this.rollNumber = rollNumber;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    private void validateMarks(int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
    }

    public int calculateTotal() {
        return marks1 + marks2 + marks3;
    }

    public double calculateAverage() {
        return Math.round(calculateTotal() / 3.0);
    }

    public String calculateGrade() {
        double avg = calculateAverage();

        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else return "D";
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + calculateTotal());
        System.out.println("Average Marks: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
    }
}
