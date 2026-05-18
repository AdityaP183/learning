package core;

public class Main {
    public static void main(String[] args) {
        Object[] data = {25, 45.67, "Aditya", true, 'A'};

        System.out.println("Array Elements:\n");

        for (Object item : data) {

            System.out.println("Value: " + item + " | Type: " + item.getClass().getSimpleName());
        }
    }
}
