package vehicles;

public class Car extends Vehicle{
    private int noOfPassengers;

    public Car(int speed, int noOfWheels, int noOfPassengers) {
        super(speed, noOfWheels);

        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public String toString() {
        return "Car -> " + super.toString() + ", No Of Passengers = " + noOfPassengers;
    }
}
