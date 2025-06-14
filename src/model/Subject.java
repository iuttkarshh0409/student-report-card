package model;

public class Subject {
    private String subjectName;
    private int marks;

    public Subject(String subjectName, int marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        // Optional: Add validation for marks (e.g., 0-100)
        this.marks = marks;
    }

    // It's good practice to override toString() for debugging and logging
    @Override
    public String toString() {
        return "Subject{" +
               "subjectName='" + subjectName + '\'' +
               ", marks=" + marks +
               '}';
    }
}
