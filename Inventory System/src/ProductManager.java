import java.io.*;

public class ProductManager {
    private final String fileName = "products.txt";

    public void addProduct(int id, String name, int quantity, double price) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(id + "," + name + "," + quantity + "," + price);
            writer.newLine();

            System.out.println("Product added successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }
    }

    public void searchProduct(int searchId) {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == searchId) {
                    System.out.println("\nProduct Found");
                    System.out.println("---------------------");
                    System.out.println("ID       : " + data[0]);
                    System.out.println("Name     : " + data[1]);
                    System.out.println("Quantity : " + data[2]);
                    System.out.println("Price    : " + data[3]);

                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Product not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file does not exist.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}