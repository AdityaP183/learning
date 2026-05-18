package vehicles;

public class Truck extends Vehicle{
    private double loadLimit;

    public Truck(int speed, int noOfWheels, double loadLimit) {
        super(speed, noOfWheels);

        this.loadLimit = loadLimit;
    }

    @Override
    public String toString() {
        return "Truck -> " + super.toString() + ", Load Limit = " + loadLimit + " tons";
    }
}
