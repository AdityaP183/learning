package ems;

public class Manager extends Employee {
    private double bonus;

    public Manager(int employeeId, String name, double basicSalary, double bonus) {
        super(employeeId, name, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bonus = Rs. " + bonus;
    }
}
