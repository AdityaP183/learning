package ems;

public class Employee {
    private int employeeId;
    private String name;
    private double basicSalary;

    public Employee(int employeeId, String name, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    @Override
    public String toString() {
        return "Employee ID = " + employeeId +
                ", Name = " + name +
                ", Salary = Rs. " + basicSalary;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Employee)) return false;

        Employee other = (Employee) obj;

        return this.employeeId == other.employeeId;
    }
}