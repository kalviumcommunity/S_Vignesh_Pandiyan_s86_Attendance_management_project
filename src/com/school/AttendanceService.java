package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private final List<AttendanceRecord> attendanceLog;
    private final FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // Overload 1: mark using objects directly
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord rec = new AttendanceRecord(student, course, status);
        attendanceLog.add(rec);
    }

    // Overload 2: mark using IDs + lookup lists
    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student s = findStudentById(studentId, allStudents);
        Course c = findCourseById(courseId, allCourses);
        if (s == null || c == null) {
            System.out.println("Warning: Cannot mark attendance. Student or Course not found for IDs: "
                    + studentId + ", " + courseId);
            return;
        }
        markAttendance(s, c, status);
    }

    private Student findStudentById(int id, List<Student> allStudents) {
        for (Student s : allStudents) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        for (Course c : allCourses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public void displayAttendanceLog() {
        System.out.println("\n--- Attendance Log: All Records ---");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records yet.");
            return;
        }
        for (AttendanceRecord rec : attendanceLog) {
            rec.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance Log: For Student " + student.getName() + " (ID: S" + student.getId() + ") ---");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getStudent().getId() == student.getId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("No records for this student.");
            return;
        }
        for (AttendanceRecord rec : filtered) rec.displayRecord();
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance Log: For Course " + course.getCourseName() + " (ID: C" + course.getCourseId() + ") ---");
        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
                .collect(Collectors.toList());
        if (filtered.isEmpty()) {
            System.out.println("No records for this course.");
            return;
        }
        for (AttendanceRecord rec : filtered) rec.displayRecord();
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
        System.out.println("\nAttendance data saved to attendance_log.txt");
    }
}
