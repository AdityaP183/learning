import java.io.*;

public class StudentRecord {
    private final String fileName = "students.txt";

    public void writeStudent(int id, String name, double marks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(id + "," + name + "," + marks);
            writer.newLine();

            System.out.println("Student record saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    public void readStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("\nStudent Records");
            System.out.println("-----------------------------");

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {
                    System.out.println("ID    : " + data[0]);
                    System.out.println("Name  : " + data[1]);
                    System.out.println("Marks : " + data[2]);
                    System.out.println("-----------------------------");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Student record file does not exist.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("File may be corrupted.");
        }
    }
}