package mypackage;

public class Student extends Person {
    protected Integer roll;
    protected String registration;

    public Student() {
        super();
        this.roll = 0;
        this.registration = "Not Assigned";
        System.out.println("Student Default Constructor Called");
    }

    public Student(String name, String aadhar, int roll, String regNo) {
        super(name, aadhar);
        this.roll = roll;
        this.registration = regNo;
        System.out.println("Student Parameterized Constructor Called");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Roll: " + roll);
        System.out.println("Registration No: " + registration);
    }
}
