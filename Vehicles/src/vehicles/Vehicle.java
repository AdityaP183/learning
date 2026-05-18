package vehicles;

public class Vehicle {
    private int speed;
    private int noOfWheels;

    public Vehicle(int speed, int noOfWheels) {
        this.speed = speed;
        this.noOfWheels = noOfWheels;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Speed = " + speed + ", No Of Wheels = " + noOfWheels;
    }
}
