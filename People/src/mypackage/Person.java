package mypackage;

public class Person {
    protected String name;
    protected String aadhar;

    public Person(){
        this.name = "Unknown";
        this.aadhar = "Not Assigned";
        System.out.println("Person Default Constructor Called");
    }

    public Person(String name, String aadhar) {
        this.name = name;
        this.aadhar = aadhar;
        System.out.println("Person Parameterized Constructor Called");
    }

    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Aadhar: " + this.aadhar);
    }
}
