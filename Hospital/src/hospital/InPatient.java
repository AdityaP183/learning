package hospital;

public class InPatient extends Patient {

    private int roomNumber;
    private int daysStayed;

    public InPatient(int patientId, String name, int age, int roomNumber, int daysStayed) {

        super(patientId, name, age);

        this.roomNumber = roomNumber;
        this.daysStayed = daysStayed;
    }

    @Override
    public double calculateBill() {

        return daysStayed * 3000;
    }

    @Override
    public void display() {

        super.display();

        System.out.println("Room Number: " + roomNumber);
        System.out.println("Days Stayed: " + daysStayed);

        System.out.println("Bill Amount: Rs. " + calculateBill());
    }
}