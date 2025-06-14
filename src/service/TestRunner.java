package service;

import model.Student;
import model.Subject;

public class TestRunner {

    public static void main(String[] args) {
        ReportCardSystem rcs = new ReportCardSystem();

        System.out.println("--- Initial Setup for Testing ---");
        rcs.addStudent(new Student("Alice Smith", 101));
        rcs.addSubject(101, "Math", 90);
        rcs.addSubject(101, "Science", 85);

        rcs.addStudent(new Student("Bob Johnson", 102));
        rcs.addSubject(102, "History", 75);
        rcs.addSubject(102, "English", 80);

        // Student to be added with no subjects initially for one of the tests
        rcs.addStudent(new Student("Charlie Brown", 103));

        System.out.println(rcs.generateReportCard(101));
        rcs.displayRankList();

        System.out.println("\n--- Starting Edge Case Tests ---");

        // 1. Test adding a student with an existing ID
        System.out.println("\n--- Test: Adding student with existing ID (101) ---");
        rcs.addStudent(101, "Another Alice"); // Uses the (int, String) overload
        // Verification: Check console output from addStudent method, and ensure original Alice is intact
        System.out.println(rcs.generateReportCard(101));


        // 2. Test adding a subject to a non-existent student
        System.out.println("\n--- Test: Adding subject to non-existent student (999) ---");
        rcs.addSubject(999, "Phantom Subject", 50);
        // Verification: Check console output from addSubject method

        // 3. Test generating a report for a non-existent student
        System.out.println("\n--- Test: Generating report for non-existent student (999) ---");
        System.out.println(rcs.generateReportCard(999));
        // Verification: Check console output

        // 4. Test student with no subjects
        System.out.println("\n--- Test: Report for student with no subjects (Charlie ID 103) ---");
        System.out.println(rcs.generateReportCard(103));
        // Verification: Check report for 0 marks, N/A or F grade etc.
        // Also check his place in rank list
        System.out.println("Rank list including Charlie:");
        rcs.displayRankList();

        // Add a subject to Charlie to see his report update
        System.out.println("\nAdding a subject to Charlie and re-checking report & rank:");
        rcs.addSubject(103, "Art", 60);
        System.out.println(rcs.generateReportCard(103));
        rcs.displayRankList();


        // 5. Test displayRankList with no students
        System.out.println("\n--- Test: Rank List with a new, empty ReportCardSystem ---");
        ReportCardSystem emptyRcs = new ReportCardSystem();
        emptyRcs.displayRankList();
        // Verification: Check console output for a message like "No students to display"

        System.out.println("\n--- Edge Case Testing Complete ---");
    }
}
