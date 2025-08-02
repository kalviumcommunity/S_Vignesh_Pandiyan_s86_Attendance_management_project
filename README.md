Welcome to my Attendance Management Project repository!  
This project is part of the Kalvium OOP course  
Session 1: Project Setup and Orientation  
Session 2: Core Domain Modelling

Project Structure:

Kishore_S86_Attendance_management_project/
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

### How to Run

1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

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
