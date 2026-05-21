package com.nish.project.model;

public class Registration {

    private int id;

    private int studentId;
    private int courseId;

    private String registrationDate;
    private String status;

    private String studentName;
    private String courseName;

    // for display (JOIN)
    public Registration(int id, String studentName, String courseName, String registrationDate, String status) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    // for insert
    public Registration(int studentId, int courseId, String registrationDate, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public int getId() { return id; }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }

    public String getStudentName() { return studentName; }
    public String getCourseName() { return courseName; }

    public String getRegistrationDate() { return registrationDate; }
    public String getStatus() { return status; }
}