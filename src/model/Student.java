package model;

import java.util.List;
import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private String name;
    private int id;
    private List<Subject> subjects;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    // It's good practice to override toString() for debugging and logging
    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", subjects=" + subjects +
               '}';
    }

    public int getTotalMarks() {
        int total = 0;
        for (Subject subject : subjects) {
            total += subject.getMarks();
        }
        return total;
    }

    public double getAverageMarks() {
        if (subjects.isEmpty()) {
            return 0.0;
        }
        return (double) getTotalMarks() / subjects.size();
    }

    public String getGrade() {
        double average = getAverageMarks();
        if (subjects.isEmpty()) { // Handle case with no subjects, though average might be 0
            return "N/A"; // Or some other appropriate grade/indicator
        }
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public int compareTo(Student other) {
        // Descending order of total marks
        return Integer.compare(other.getTotalMarks(), this.getTotalMarks());
    }
}
