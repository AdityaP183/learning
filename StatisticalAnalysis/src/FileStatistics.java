import java.io.*;

public class FileStatistics {
    public void analyzeFile(String filePath) {
        int lineCount = 0;
        int wordCount = 0;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                String[] words = line.trim().split("\\s+");

                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            System.out.println("Total Lines : " + lineCount);
            System.out.println("Total Words : " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
