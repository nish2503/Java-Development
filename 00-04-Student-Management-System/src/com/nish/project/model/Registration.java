package com.nish.project.model;

public class Registration {

    private int regId;
    private int studentId;
    private int courseId;
    private double feesPaid;

    public Registration(int regId, int studentId, int courseId, double feesPaid) {
        this.regId = regId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.feesPaid = feesPaid;
    }

    public int getRegId() {
        return regId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }
}