package core;

import filehandler.EmptyFileException;
import filehandler.FileReaderUtil;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        FileReaderUtil reader = new FileReaderUtil();

        try {
            reader.readFile(fileName);

        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found.");

        } catch (EmptyFileException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
