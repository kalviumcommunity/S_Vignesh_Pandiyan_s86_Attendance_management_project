package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
 public static void main(String[] args) {
 System.out.println("--- School Attendance System ---");
    Student[] students = {
            new Student("Alice Wonderland"),
            new Student("Bob The Builder"),
            new Student("Charlie Bucket")
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
        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(),courses[0].getCourseId(),"Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(),courses[1].getCourseId(),"Present"));
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(),courses[2].getCourseId(),"Present"));

        System.out.println("\nAttendance Log:");
        for (AttendanceRecord rec : attendanceLog)
            rec.displayRecord();

        System.out.println("\nSession 4: Encapsulation & Attendance Recording Complete.");
    }
}
