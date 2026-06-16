import java.io.*;

public class StringCounter {
    public void countOccurrences(String filePath, String searchString) {
        int count = 0;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                searchString = searchString.toLowerCase();

                String[] words = line.split("[^a-zA-Z]+");

                for (String word : words) {
                    if (word.equals(searchString)) {
                        count++;
                    }
                }
            }

            System.out.println("\nThe word \"" + searchString +
                    "\" occurred " + count + " times.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
