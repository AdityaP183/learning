package employee;

public class Employee {
    private final String name;
    private final int age;
    private final double salary;

    public Employee(String name, int age, double salary) throws InvalidAgeException {
        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Employee age must be between 18 and 60.");
        }

        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void display() {

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: Rs. " + salary);
    }
}
