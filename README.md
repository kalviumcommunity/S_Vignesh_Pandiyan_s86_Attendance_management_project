Welcome to my Attendance Management Project repository!  
This project is part of the Kalvium OOP course  
Session 1: Project Setup and Orientation  
Session 2: Core Domain Modelling

Project Structure:

S_Vignesh_Pandiyan_S86_Attendance_management_project/
├── src/
│ └── com/
│ └── school/
│ ├── Main.java
│ ├── Student.java
│ └── Course.java
└── README.md

---

🛠 How to Compile and Run

Navigate to the project root directory (the one containing src and README.md)

Compile the code:

javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java  
or  
javac src/com/school/\*.java

Run the program:

java -cp src com.school.Main

Expected Output:

Welcome to the School Attendance System Project!  
Session 1: Project Setup and Orientation Complete  
Session 2: Student and Course objects displayed with details

---

## Session 2: Core Domain Modelling

- Defined `Student` class with `studentId`, `name`, `setDetails()`, and `displayDetails()` method.
- Defined `Course` class with `courseId`, `courseName`, `setDetails()`, and `displayDetails()` method.
- Utilized arrays of objects in `Main.java` to manage and display multiple students and courses.
- Introduced basic usage of `this` keyword.

## Session 3: Constructor Initialization & Auto-ID Generation

- Implemented parameterized constructors in `Student` and `Course` for object initialization.
- Used `private static` variables for automatic unique ID generation, with prefix "S" and "C" shown in output.
- Removed manual setDetails; all objects now fully initialized at construction.
- Demonstrated automatic ID progression in `Main.java`.

## Part 4: Data Encapsulation & Attendance Recording Validation

- Applied encapsulation to `Student` and `Course` classes by making fields `private` and adding public `getters`.
- Introduced a new `AttendanceRecord` class with `private` fields, a constructor, and `getters` to store attendance data.
- Implemented basic validation in the `AttendanceRecord` constructor for the attendance status (allowing only "Present" or "Absent").
- Used an `ArrayList` in `Main.java` to store and display `AttendanceRecord` objects.
- Demonstrated retrieving IDs using getters (e.g., `student1.getStudentId()`) when creating records.

## Part 5: Establishing Students, Teaching & Non-Teaching Staff Hierarchy

- Created base class Person for common attributes and auto-ID assignment.
- Refactored Student to inherit from Person; added gradeLevel.
- Implemented Teacher and Staff subclasses with role-specific fields.
- Overrode displayDetails() in each subclass to show details accordingly.
- Updated main code to instantiate and display different Person types.
- Used polymorphism and inheritance to simplify and unify ID handling.

## Part 6: Interface-Driven Persistence with Storage

- Defined a `Storable` interface with a `toDataString()` method.
- Modified `Student`, `Course`, and `AttendanceRecord` to implement `Storable` and provide CSV string output.
- Created a `FileStorageService` class for saving any list of `Storable` objects to a text file.
- Demonstrated in `Main.java` how to save lists of students, courses, and attendance records with one method call each.
- Output files: `students.txt`, `courses.txt`, `attendance_log.txt`.

## Part 7: Polymorphic Behaviour in Attendance and Displaying Reports

- Modified `AttendanceRecord` to hold `Student` and `Course` objects instead of just their IDs, enhancing its object-oriented nature and how records are displayed. The `toDataString()` method still uses IDs for simpler file storage.
- Created a `displaySchoolDirectory(List<Person> people)` method in `Main.java` to demonstrate polymorphism. This method iterates through a list of `Person` objects (containing `Student`, `Teacher`, `Staff` instances) and calls `person.displayDetails()`. The correct overridden method for each specific object type is executed at runtime.
- Populated a `List<Person>` in `main` and used it with `displaySchoolDirectory`.
- Updated `Main.java` to use `instanceof` and casting when preparing the list of students for saving, as `Person` itself does not implement `Storable`.
- Discussed how polymorphism allows for flexible and extensible code by treating different object types uniformly through a common interface or base class reference.

## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance

- Created an `AttendanceService.java` class to encapsulate attendance logic and manage the list of `AttendanceRecord` objects.
- Implemented overloaded `markAttendance` methods in `AttendanceService`:
  - `markAttendance(Student student, Course course, String status)`
  - `markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses)` (performs lookups)
- Implemented overloaded `displayAttendanceLog` methods in `AttendanceService`:
  - `displayAttendanceLog()` (shows all records)
  - `displayAttendanceLog(Student student)` (filters by student)
  - `displayAttendanceLog(Course course)` (filters by course)
- Utilized Java Streams for filtering records in the specific display methods.
- `AttendanceService` now uses `FileStorageService` to save its `attendanceLog`.
- Demonstrated the use of these overloaded methods in `Main.java`, showing how different method signatures allow for flexible ways to call the same conceptual operation.

## Part 9: SOLID Service Layer: RegistrationService & AttendanceService Separation

- Applied the Single Responsibility Principle (SRP) by creating dedicated service classes.
- Created `RegistrationService.java` to handle the registration, management (lists, lookups), and saving of `Student`, `Teacher`, `Staff`, and `Course` entities.
- Modified `Teacher.java` and `Staff.java` to implement `Storable` for file persistence.
- Refactored `AttendanceService.java`:
  - It now depends on `RegistrationService` for looking up students/courses by ID.
  - Removed internal lookup helper methods, delegating this to `RegistrationService`.
  - Its primary focus is now solely on managing attendance records.
- Updated `Main.java` to act as an orchestrator, instantiating and using these services. Direct entity list management was removed from `Main`.
- Demonstrated improved code organization and clearer separation of concerns.

### How to Run

1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check for `students.txt`, `teachers.txt`, `staff.txt`, `courses.txt`, and `attendance_log.txt`.

📝 Git Workflow

Configure your Git identity:

git config --global user.name "your-github-username"  
git config --global user.email "your-github-email"

Initialize, add, and commit your code:

git checkout -b part-01  
git add .  
git commit -m "feat: Initial project setup and core domain modelling (Part 1 and 2)"

Add the remote repository and push:

git remote add origin your-repo-url.git  
git push -u origin part-01
