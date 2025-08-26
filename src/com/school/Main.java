package com.school;

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

        System.out.println("\nSession 3: Constructor & Auto-ID Complete.");
    }
}
