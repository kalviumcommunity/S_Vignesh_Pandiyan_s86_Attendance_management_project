package com.school;

import java.util.List;

public class Main {

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory (Polymorphic Display) ---");
        List<Person> people = regService.getAllPeople();
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        Student s1 = regService.registerStudent("Alice Wonderland", "10-A");
        Student s2 = regService.registerStudent("Bob The Builder", "10-B");
        Student s3 = regService.registerStudent("Charlie Bucket", "11-C");

        Teacher t1 = regService.registerTeacher("Dr. Watson", "Mathematics");
        Staff staff1 = regService.registerStaff("John Smith", "Office Admin");

        Course c1 = regService.createCourse("Intro to Programming");
        Course c2 = regService.createCourse("Linear Algebra");
        Course c3 = regService.createCourse("Data Structures");

        displaySchoolDirectory(regService);

        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Present");
        attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Absent");

        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(s1);
        attendanceService.displayAttendanceLog(c2);

        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nSession 9: SOLID Service Layer Complete.");
    }
}
