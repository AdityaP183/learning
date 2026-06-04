package vms;

public class Car extends Vehicle{
    private int numberOfDoors;

    public Car(String brand, int speed, int numberOfDoors) {
        super(brand, speed);

        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {

        System.out.println("Car Details:");
        System.out.println("Brand: " + getBrand());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Number Of Doors: " + numberOfDoors);
    }
}
