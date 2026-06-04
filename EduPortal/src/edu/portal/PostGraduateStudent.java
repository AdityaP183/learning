package edu.portal;

public class PostGraduateStudent extends Student {
    private String researchTopic;

    public PostGraduateStudent(int studentId,
                               String name,
                               int marks1,
                               int marks2,
                               int marks3,
                               String researchTopic) {

        super(studentId, name, marks1, marks2, marks3);

        this.researchTopic = researchTopic;
    }

    public void displayResearchInfo() {

        System.out.println(
                "Research Topic: " + researchTopic
        );
    }
}
