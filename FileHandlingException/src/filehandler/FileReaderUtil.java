package filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderUtil {
    public void readFile(String fileName) throws FileNotFoundException, EmptyFileException {
        File file = new File(fileName);

        Scanner sc = new Scanner(file);
        if (!sc.hasNextLine()) {
            sc.close();
            throw new EmptyFileException("File exists but is empty.");
        }

        System.out.println("\nFile Content:\n");

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}
