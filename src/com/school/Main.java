package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory (Polymorphic Display) ---");
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Students
        Student s1 = new Student("Alice Wonderland", "10-A");
        Student s2 = new Student("Bob The Builder", "10-B");
        Student s3 = new Student("Charlie Bucket", "11-C");

        // Teacher and Staff
        Teacher t1 = new Teacher("Dr. Watson", "Mathematics");
        Staff staff1 = new Staff("John Smith", "Office Admin");

        // Courses
        Course c1 = new Course("Intro to Programming");
        Course c2 = new Course("Linear Algebra");
        Course c3 = new Course("Data Structures");

        // Polymorphic directory
        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1); schoolPeople.add(s2); schoolPeople.add(s3);
        schoolPeople.add(t1); schoolPeople.add(staff1);
        displaySchoolDirectory(schoolPeople);

        ArrayList<Student> students = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) students.add((Student) p);
        }
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1); courses.add(c2); courses.add(c3);

        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        // Part 08: Overloaded markAttendance()
        // Overload 1: using objects
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c2, "Present");
        // Overload 2: using IDs + lookup lists
        attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Absent", students, courses);

        // Part 08: Overloaded displayAttendanceLog()
        attendanceService.displayAttendanceLog();         
        attendanceService.displayAttendanceLog(s1);       
        attendanceService.displayAttendanceLog(c2);       
        attendanceService.saveAttendanceData();

        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");

        System.out.println("\nSession 8: Overloaded Commands for Attendance Complete.");
    }
}
