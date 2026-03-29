package com.nish.TestAssignment.StudentEnrollmentSystem;

public abstract class Student {

    private int studentId;
    private String name;
    private String course;

    public Student(int studentId, String name, String course) {

        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Invalid name");

        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void displayDetails() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}