package com.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice Wonderland", "10-A"));
        students.add(new Student("Bob The Builder", "10-B"));
        students.add(new Student("Charlie Bucket", "11-C"));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Intro to Programming"));
        courses.add(new Course("Linear Algebra"));
        courses.add(new Course("Data Structures"));

        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            student.displayDetails();
        }

        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            course.displayDetails();
        }

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(2).getId(), courses.get(2).getCourseId(), "Present"));

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord rec : records) {
            rec.displayRecord();
        }

        FileStorageService fileService = new FileStorageService();
        fileService.saveData(students, "students.txt");
        fileService.saveData(courses, "courses.txt");
        fileService.saveData(records, "attendance_log.txt");

        System.out.println("\nSession 6: Interface-Driven Persistence & Storage Complete.");
    }
}
