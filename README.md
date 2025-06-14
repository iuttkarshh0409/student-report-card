# Simple Report Card System

This project is a simple command-line based Report Card System implemented in Java.
It allows for creating students, adding subjects with marks, and generating a report card that includes total marks and average percentage.

## Project Structure

The project is organized into two main packages:

- `model`: Contains the data classes.
  - `Student.java`: Represents a student with a name, ID, and a list of subjects.
  - `Subject.java`: Represents a subject with a name and marks obtained.
- `service`: Contains the application logic.
  - `ReportCardSystem.java`: Manages students and provides functionalities like adding students, adding subjects to students, and generating report cards.
  - `Main.java`: The entry point of the application, demonstrating the usage of the `ReportCardSystem`.

## How to Compile and Run

1.  **Navigate to the source directory**:
    Open a terminal or command prompt and change the directory to the `src` folder within the project.
    ```bash
    cd path/to/your/project/ReportCardSystem/src
    ```

2.  **Compile the Java files**:
    Use the Java compiler (`javac`) to compile all the source files. The `-d .` option ensures that the compiled `.class` files are placed in the correct package structure within the current directory (`src`).
    ```bash
    javac -d . model/Student.java model/Subject.java service/ReportCardSystem.java service/Main.java
    ```
    Alternatively, you can compile all `.java` files if they are the only Java files in their respective directories:
    ```bash
    javac -d . model/*.java service/*.java
    ```

3.  **Run the application**:
    Execute the `Main` class using the `java` command. You need to provide the fully qualified name of the main class (including its package).
    ```bash
    java service.Main
    ```

## Example Output

The `Main.java` class demonstrates the system's functionality by:
- Creating a few students.
- Adding subjects and marks for them.
- Generating and printing their report cards.
- Attempting to generate a report for a non-existent student.
- Listing all registered students.

The output will look something like this:

```
Generating Report Cards:

Report Card for: Alice Smith (ID: 101)
--------------------------------------------------
Subject              | Marks
--------------------------------------------------
Math                 | 90
Science              | 85
English              | 78
--------------------------------------------------
Total Marks: 253
Average Percentage: 84.33%
--------------------------------------------------

Report Card for: Bob Johnson (ID: 102)
--------------------------------------------------
Subject              | Marks
--------------------------------------------------
Math                 | 75
History              | 88
Geography            | 92
--------------------------------------------------
Total Marks: 255
Average Percentage: 85.00%
--------------------------------------------------

Report Card for: Charlie Brown (ID: 103)
--------------------------------------------------
Subject              | Marks
--------------------------------------------------
No subjects enrolled.
--------------------------------------------------
Total Marks: 0
Average Percentage: 0.00%
--------------------------------------------------

Student with ID 999 not found.

Listing all students:
- Alice Smith (ID: 101)
- Bob Johnson (ID: 102)
- Charlie Brown (ID: 103)
```

## Further Improvements (Optional)

- Add input validation (e.g., marks between 0-100).
- Implement features to update or delete students and subjects.
- Persist data to a file or database.
- Add more comprehensive error handling.
- Create unit tests.
- Develop a graphical user interface (GUI).
```
