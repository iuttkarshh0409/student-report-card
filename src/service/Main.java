package service;

import model.Student;
import model.Subject;
import java.util.List; // Added import for List

public class Main {
    public static void main(String[] args) {
        ReportCardSystem rcs = new ReportCardSystem();

        // Create and add students
        Student student1 = new Student("Alice Smith", 101);
        Student student2 = new Student("Bob Johnson", 102);
        rcs.addStudent(student1);
        rcs.addStudent(student2);

        // Add subjects and marks for Alice
        rcs.addSubjectToStudent(101, new Subject("Math", 90));
        rcs.addSubjectToStudent(101, new Subject("Science", 85));
        rcs.addSubjectToStudent(101, new Subject("English", 78));

        // Add subjects and marks for Bob
        rcs.addSubjectToStudent(102, new Subject("Math", 75));
        rcs.addSubjectToStudent(102, new Subject("History", 88));
        rcs.addSubjectToStudent(102, new Subject("Geography", 92));

        // Add a student with no subjects
        Student student3 = new Student("Charlie Brown", 103);
        rcs.addStudent(student3);

        // Generate and print report cards
        System.out.println("Generating Report Cards:\n");

        System.out.println(rcs.generateReportCard(101));
        System.out.println(rcs.generateReportCard(102));
        System.out.println(rcs.generateReportCard(103)); // Student with no subjects
        System.out.println(rcs.generateReportCard(999)); // Non-existent student

        // Demonstrate using new overloaded methods
        System.out.println("\nUsing overloaded methods to add student and subjects:");
        rcs.addStudent(104, "Diana Prince"); // New student
        rcs.addSubject(104, "Ancient History", 95);
        rcs.addSubject(104, "Combat Skills", 98);

        rcs.addSubject(101, "Physics", 70); // Add new subject to Alice

        System.out.println("\nReport Card for Diana Prince (after adding with new methods):");
        System.out.println(rcs.generateReportCard(104));
        System.out.println("\nReport Card for Alice Smith (after adding Physics):");
        System.out.println(rcs.generateReportCard(101));


        // Demonstrate getting all students (optional)
        System.out.println("\nListing all students (after additions):");
        for (Student s : rcs.getAllStudents()) {
            System.out.println("- " + s.getName() + " (ID: " + s.getId() + ")");
        }

        // Demonstrate student ranking by calling the new method in ReportCardSystem
        rcs.displayRankList();
    }
}
