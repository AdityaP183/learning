package core;

import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {

        Car car = new Car(180, 4, 5);
        Truck truck = new Truck(120, 6, 15);

        System.out.println(car);
        System.out.println(truck);
        
		compareSpeed(car, truck);
    }

    public static void compareSpeed(Vehicle v1, Vehicle v2) {

        if (v1.getSpeed() > v2.getSpeed()) {
            System.out.println("\nCar is faster than Truck");
        } else if (v1.getSpeed() < v2.getSpeed()) {
            System.out.println("\nTruck is faster than Car");
        } else {
            System.out.println("\nBoth vehicles have identical speed");
        }
    }
}
