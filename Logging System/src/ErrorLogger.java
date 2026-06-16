import java.io.*;

public class ErrorLogger {
    private final String fileName = "error_log.txt";

    public void logError(String errorMessage) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(errorMessage);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Unable to write to log file.");
        }
    }

    public void displayLogs() {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            System.out.println("\nError Log Contents");
            System.out.println("----------------------");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Log file not found.");
        } catch (IOException e) {
            System.out.println("Error reading log file.");
        }
    }
}
