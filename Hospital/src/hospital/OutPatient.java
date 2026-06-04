package hospital;

public class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void display() {
        super.display();

        System.out.println("Consultation Fee: Rs. " + consultationFee);

        System.out.println("Bill Amount: Rs. " + calculateBill());
    }
}