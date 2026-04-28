package com.nish.project.model;

public class Course {

    private int courseId;
    private String courseName;
    private int branchId;

    public Course(int courseId, String courseName, int branchId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.branchId = branchId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}