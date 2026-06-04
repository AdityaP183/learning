package core;

import hospital.InPatient;
import hospital.OutPatient;
import hospital.Patient;

public class Main {
    public static void main(String[] args) {
        Patient p1 = new InPatient(
                101,
                "Aditya",
                22,
                305,
                5
        );

        Patient p2 = new OutPatient(
                102,
                "Rahul",
                30,
                800
        );

        System.out.println("\nInPatient Details:\n");
        p1.display();

        System.out.println("\nOutPatient Details:\n");
        p2.display();
    }
}