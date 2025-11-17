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

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(s1, c1, "Present"));
        records.add(new AttendanceRecord(s2, c2, "Present"));
        records.add(new AttendanceRecord(s3, c3, "Absent"));

        System.out.println("\n--- Attendance Log (Object-based) ---");
        for (AttendanceRecord rec : records) {
            rec.displayRecord();
        }

        FileStorageService storage = new FileStorageService();

        ArrayList<Student> students = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) students.add((Student)p);
        }

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1); courses.add(c2); courses.add(c3);

        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("\nSession 7: Polymorphism & Reports Complete.");
    }
}
