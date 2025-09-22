package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        Student[] students = {
            new Student("Alice Wonderland", "10-A"),
            new Student("Bob The Builder", "10-B"),
            new Student("Charlie Bucket", "11-C")
        };

        Course[] courses = {
            new Course("Intro to Programming"),
            new Course("Linear Algebra"),
            new Course("Data Structures")
        };

        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            if (student != null) student.displayDetails();
        }

        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            if (course != null) course.displayDetails();
        }

        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "Present"));

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord rec : attendanceLog) {
            rec.displayRecord();
        }

        System.out.println("\nSession 5: Students, Teachers & Staff Hierarchy Complete.");
    }
}
