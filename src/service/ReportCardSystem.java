package service;

import model.Student;
import model.Subject;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections; // Added for sorting

public class ReportCardSystem {
    private Map<Integer, Student> students;

    public ReportCardSystem() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void addStudent(int id, String name) {
        if (students.containsKey(id)) {
            System.out.println("Student with ID " + id + " already exists.");
            return;
        }
        // Assuming Student constructor is Student(String name, int id)
        Student newStudent = new Student(name, id);
        students.put(id, newStudent);
        // System.out.println("Student " + name + " with ID " + id + " added."); // Optional: logging
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    // Overloaded addSubjectToStudent, renamed to addSubject for clarity as per common practice
    // The original script implied renaming or choosing this as the new primary.
    // To avoid conflict and maintain clarity, I'll name it addSubject as requested.
    // The existing addSubjectToStudent(int studentId, Subject subject) can remain or be deprecated.
    // For this task, I'm adding the new one as specified.
    public void addSubject(int studentId, String subjectName, int marks) {
        Student student = students.get(studentId);
        if (student != null) {
            // Assuming Subject constructor is Subject(String subjectName, int marks)
            Subject newSubject = new Subject(subjectName, marks);
            student.addSubject(newSubject);
            // System.out.println("Subject " + subjectName + " added to student ID " + studentId + "."); // Optional: logging
        } else {
            System.out.println("Cannot add subject: Student with ID " + studentId + " not found.");
        }
    }

    public void addSubjectToStudent(int studentId, Subject subject) {
        Student student = students.get(studentId);
        if (student != null) {
            student.addSubject(subject);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public String generateReportCard(int studentId) {
        Student student = students.get(studentId);
        if (student == null) {
            return "Student with ID " + studentId + " not found.";
        }

        StringBuilder report = new StringBuilder();
        report.append("Report Card for: ").append(student.getName()).append(" (ID: ").append(student.getId()).append(")\n");
        report.append("--------------------------------------------------\n");
        report.append(String.format("%-20s | %-10s\n", "Subject", "Marks"));
        report.append("--------------------------------------------------\n");

        List<Subject> subjects = student.getSubjects();
        if (subjects.isEmpty()) {
            report.append("No subjects enrolled.\n");
        } else {
            for (Subject subject : subjects) {
                report.append(String.format("%-20s | %-10d\n", subject.getSubjectName(), subject.getMarks()));
            }
        }
        report.append("--------------------------------------------------\n");
        report.append("Total Marks: ").append(student.getTotalMarks()).append("\n");
        report.append("Average Percentage: ").append(String.format("%.2f%%", student.getAverageMarks())).append("\n");
        report.append("Grade: ").append(student.getGrade()).append("\n"); // Added Grade
        report.append("--------------------------------------------------\n");

        return report.toString();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public List<Student> getRankedStudents() {
        List<Student> studentList = new ArrayList<>(students.values());
        Collections.sort(studentList); // Sorts using Student's compareTo method
        return studentList;
    }

    public void displayRankList() {
        List<Student> rankedStudents = getRankedStudents();
        if (rankedStudents.isEmpty()) {
            System.out.println("No students to display in rank list.");
            return;
        }

        System.out.println("\n--- Student Rank List ---");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-5s | %-20s | %-12s | %-5s%n", "Rank", "Name", "Total Marks", "Grade");
        System.out.println("----------------------------------------------------------");
        int rank = 1;
        for (Student student : rankedStudents) {
            System.out.printf("%-5d | %-20s | %-12d | %-5s%n",
                    rank++,
                    student.getName(),
                    student.getTotalMarks(),
                    student.getGrade());
        }
        System.out.println("----------------------------------------------------------");
    }
}
