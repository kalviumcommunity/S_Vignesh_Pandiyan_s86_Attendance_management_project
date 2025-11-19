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

        Course c1 = regService.createCourse("Intro to Programming", 2);
        Course c2 = regService.createCourse("Linear Algebra", 1);
        Course c3 = regService.createCourse("Data Structures", 2);

        displaySchoolDirectory(regService);

        // Enrollments (include one that exceeds capacity)
        regService.enrollStudentInCourse(s1, c1); // ok
        regService.enrollStudentInCourse(s2, c1); // ok
        regService.enrollStudentInCourse(s3, c1); // exceeds capacity -> should fail

        regService.enrollStudentInCourse(s1, c2); // ok
        regService.enrollStudentInCourse(s2, c2); // fail (capacity 1)

        regService.enrollStudentInCourse(s2, c3); // ok
        regService.enrollStudentInCourse(s3, c3); // ok

        // Show updated course details (capacity + enrolled count)
        System.out.println("\n--- Courses After Enrollment ---");
        for (Course c : regService.getCourses()) {
            c.displayDetails();
        }

        // (Optional) Before marking attendance, you could check enrollment.
        // For brevity, we mark attendance as before.
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Present");
        attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Absent");

        attendanceService.displayAttendanceLog();

        // Persist all
        regService.saveAllRegistrations(); // courses.txt now includes capacity
        attendanceService.saveAttendanceData();

        System.out.println("\nSession 10: Capacity Management Complete.");
    }
}
