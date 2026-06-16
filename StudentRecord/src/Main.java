import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecord sr = new StudentRecord();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        sr.writeStudent(id, name, marks);

        System.out.println("\nReading Data From File...");
        sr.readStudents();

        sc.close();
    }
}
