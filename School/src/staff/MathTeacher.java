package staff;

public class MathTeacher extends Teacher{
    private String subjectOfInterest;

    public MathTeacher() {
        super();

        this.subjectOfInterest = "Mathematics";

        System.out.println("MathTeacher Default Constructor Called");
    }

    public MathTeacher(String name, String collegeName, String subjectOfInterest) {
        super(name, collegeName);

        this.subjectOfInterest = subjectOfInterest;

        System.out.println("MathTeacher Parameterized Constructor Called");
    }

    @Override
    public void display() {
        super.display();

        System.out.println("Subject Of Interest: " + subjectOfInterest);
    }
}
