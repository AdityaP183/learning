package vms;

public class Bike extends Vehicle {
    private double mileage;

    public Bike(String brand, int speed, double mileage) {
        super(brand, speed);

        this.mileage = mileage;
    }

    @Override
    public void displayDetails() {

        System.out.println("Bike Details:");
        System.out.println("Brand: " + getBrand());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Mileage: " + mileage + " km/l");
    }
}
