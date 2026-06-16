import java.io.*;

public class BorrowerManager {
    private final String fileName = "borrowers.txt";

    public void addBorrower(int id, String name, String book) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(id + "," + name + "," + book);
            writer.newLine();

            System.out.println("Borrower record added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void displayBorrowers() {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;
            System.out.println("\nBorrower Records");
            System.out.println("-----------------------------");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) {
                    System.out.println("ID            : " + data[0]);
                    System.out.println("Name          : " + data[1]);
                    System.out.println("Borrowed Book : " + data[2]);
                    System.out.println("-----------------------------");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Borrower file not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
