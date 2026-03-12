package com.nish.ArrayOfObjects.Model;

public class Course {
	private String courseId;
	private String courseName;
	private double baseFee = 1000;
	public static int counter = 0;
	
	public Course(String courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
		counter++;
	}
	
	public double calculateFee() {
		return baseFee;
	}
	
	public void courseDetails() {
		System.out.println("Course ID: " + courseId);
		System.out.println("Course Name: " + courseName);
	}
	
	public int courseCount() {
		return counter;
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
}
