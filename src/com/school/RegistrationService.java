package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Staff> staffMembers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final FileStorageService storage;

    public RegistrationService(FileStorageService storage) {
        this.storage = storage;
    }

    public Student registerStudent(String name, String gradeLevel) {
        Student s = new Student(name, gradeLevel);
        students.add(s);
        return s;
    }

    public Teacher registerTeacher(String name, String subjectTaught) {
        Teacher t = new Teacher(name, subjectTaught);
        teachers.add(t);
        return t;
    }

    public Staff registerStaff(String name, String role) {
        Staff st = new Staff(name, role);
        staffMembers.add(st);
        return st;
    }

    // Updated: createCourse takes capacity
    public Course createCourse(String courseName, int capacity) {
        Course c = new Course(courseName, capacity);
        courses.add(c);
        return c;
    }

    // Keep old overload if referenced elsewhere (optional)
    public Course createCourse(String courseName) {
        return createCourse(courseName, 30);
    }

    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    public Student findStudentById(int id) {
        for (Student s : students) if (s.getId() == id) return s;
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) if (c.getCourseId() == id) return c;
        return null;
    }

    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        people.addAll(students);
        people.addAll(teachers);
        people.addAll(staffMembers);
        return people;
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean ok = course.addStudent(student);
        if (ok) {
            System.out.println("Enrolled " + student.getName() + " (S" + student.getId() + ") in "
                    + course.getCourseName() + " (C" + course.getCourseId() + ")");
        } else {
            System.out.println("Failed to enroll " + student.getName() + " (S" + student.getId()
                    + ") in " + course.getCourseName() + " (C" + course.getCourseId()
                    + "): capacity full (" + course.getCapacity() + ")");
        }
        return ok;
    }

    public void saveAllRegistrations() {
        storage.saveData(students, "students.txt");
        storage.saveData(teachers, "teachers.txt");
        storage.saveData(staffMembers, "staff.txt");
        storage.saveData(courses, "courses.txt"); // now includes capacity
    }
}
