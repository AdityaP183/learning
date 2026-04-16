package student;

public class Student {
    private String Name;
    private Integer Roll;
    private Integer Marks;
    private String Year;

    public Student() {
        this.Name = null;
        this.Roll = 0;
        this.Marks = -1;
        this.Year = null;
    }

    public Student(String Name, Integer Roll, Integer Marks, String Year) {
        this.Name = Name;
        this.Roll = Roll;
        this.Marks = Marks;
        this.Year = Year;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getRoll() {
        return Roll;
    }

    public void setRoll(Integer roll) {
        Roll = roll;
    }

    public Integer getMarks() {
        return Marks;
    }

    public void setMarks(Integer marks) {
        Marks = marks;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String display() {
        return "Name: " + this.Name +
                ", Roll: " + this.Roll +
                ", Marks: " + this.Marks +
                ", Year: " + this.Year;
    }

    public void displayRollName() {
        System.out.println("Roll: " + this.Roll + ", Name: " + this.Name);
    }
}
