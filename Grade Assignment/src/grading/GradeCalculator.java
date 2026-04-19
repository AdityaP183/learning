package grading;

import static java.lang.Math.floor;

public class GradeCalculator {
    public boolean isValid(int m1, int m2, int m3) {
        return (m1 > 0 && m1 < 100) && (m2 > 0 && m2 < 100) && (m3 > 0 && m3 < 100);
    }

    public int total(int m1, int m2, int m3) {
        return m1 + m2 + m3;
    }

    public double average(int total) {
        return floor(total / 3.0);
    }

    public char getGrade(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else return 'D';
    }
}
