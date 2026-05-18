package staff;

public class Teacher {
    private String name;
    private String collegeName;

    public Teacher() {
        this.name = "Unknown";
        this.collegeName = "Not Assigned";

        System.out.println("Teacher Default Constructor Called");
    }

    public Teacher(String name, String collegeName) {
        this.name = name;
        this.collegeName = collegeName;

        System.out.println("Teacher Parameterized Constructor Called");
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("College Name: " + collegeName);
    }
}
