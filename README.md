# Student Report Card System (v1)

## Overview

This project is a command-line Java application that manages student records, including their subjects, marks, grades, and rankings. It demonstrates object-oriented programming principles and the use of the Java Collection Framework (JCF). The system allows for adding students, adding subjects with marks to students, generating individual report cards, and displaying a ranked list of all students based on their total marks.

## Features

- **Student Management:**
    - Add new students with a unique ID and name.
    - Prevents adding students with duplicate IDs.
- **Subject Management:**
    - Add subjects with marks to specific students.
    - Handles attempts to add subjects to non-existent students.
- **Report Card Generation:**
    - Generate a detailed report card for each student, showing:
        - Student's name and ID.
        - List of subjects with marks obtained in each.
        - Total marks obtained.
        - Average percentage.
        - Calculated grade (A, B, C, D, F, or N/A if no subjects).
    - Handles requests for report cards of non-existent students.
- **Grading System:**
    - Grades are calculated based on the average percentage:
        - A: >= 90%
        - B: >= 80%
        - C: >= 70%
        - D: >= 60%
        - F: < 60%
        - N/A: If no subjects or average cannot be determined.
- **Ranking:**
    - Display a ranked list of all students in descending order of their total marks.
    - The list includes Rank, Name, Total Marks, and Grade.
    - Handles displaying the rank list when no students are in the system.
- **Edge Case Handling:**
    - Includes basic checks for invalid operations (e.g., actions on non-existent entities).
    - A `TestRunner.java` class is provided to demonstrate some of this handling.

## Technologies Used

- **Java:** Core programming language.
- **Java Collection Framework (JCF):**
    - `List` (specifically `ArrayList`) for storing subjects within a student.
    - `Map` (specifically `HashMap`) for storing students in the report card system, keyed by student ID.
    - `Collections.sort()` for sorting students (leveraging the `Comparable` interface implemented by the `Student` class).
- **Object-Oriented Programming (OOP):** Encapsulation, Abstraction.

## How to Run

1.  **Prerequisites:**
    - Java Development Kit (JDK) installed (e.g., JDK 8 or newer).

2.  **Compilation:**
    - Navigate to the root directory of the project.
    - Create an output directory (e.g., `out`): `mkdir out`
    - Compile all Java source files:
      ```bash
      find src -name "*.java" > sources.txt
      javac -cp . -d out @sources.txt
      rm sources.txt
      ```

3.  **Running the Main Application (Demonstration):**
    - The `Main.java` class provides a sample demonstration of the system's features.
      ```bash
      java -cp ./out service.Main
      ```

4.  **Running the Edge Case Tests:**
    - The `TestRunner.java` class demonstrates various edge case handling scenarios.
      ```bash
      java -cp ./out service.TestRunner
      ```

## Sample Output

Below is a conceptual representation of what the output might look like when running `service.Main` or `service.TestRunner`. The exact output will depend on the specific data and operations performed.

**Sample: Individual Report Card (from `service.Main` or `service.TestRunner`)**
```
Report Card for: Alice Smith (ID: 101)
--------------------------------------------------
Subject              | Marks
--------------------------------------------------
Math                 |         90
Science              |         85
Physics              |         70
--------------------------------------------------
Total Marks: 245
Average Percentage: 81.67%
Grade: B
--------------------------------------------------
```

**Sample: Student Rank List (from `service.Main` or `service.TestRunner`)**
```
--- Student Rank List ---
----------------------------------------------------------
Rank  | Name                 | Total Marks  | Grade
----------------------------------------------------------
1     | Bob Johnson          | 155          | C
2     | Alice Smith          | 245          | B
3     | Diana Prince         | 193          | A
4     | Charlie Brown        | 60           | D
----------------------------------------------------------
(Note: Actual marks, grades, and order will vary based on test data)
```

**Sample: Edge Case - Report for Non-existent Student (from `service.TestRunner`)**
```
--- Test: Generating report for non-existent student (999) ---
Student with ID 999 not found.
```
