package core;

import vms.Bike;
import vms.Car;
import vms.Vehicle;

public class Main {
    static void main(String[] args) {
        Vehicle v1 = new Car("Toyota", 180, 4);

        Vehicle v2 = new Bike("Yamaha", 120, 45);

        System.out.println();
        v1.displayDetails();

        System.out.println();
        v2.displayDetails();
    }
}
