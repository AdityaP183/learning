import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String filePath = "..\\FilePractice\\tmp\\file1.txt";

        System.out.print("Enter search string: ");
        String searchString = sc.nextLine();

        StringCounter counter = new StringCounter();

        counter.countOccurrences(filePath, searchString);

        sc.close();
    }
}
