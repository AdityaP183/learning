package vms;

public class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    protected String getBrand() {
        return brand;
    }

    protected int getSpeed() {
        return speed;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}
