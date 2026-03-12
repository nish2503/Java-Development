package com.nish.ArrayOfObjects.Model;

public class RegularCourse extends Course {
	private double regularFee;
	
	public RegularCourse(String courseId, String courseName, double regularFee){
		super(courseId, courseName);
		this.regularFee = regularFee;
	}
	
	@Override 
	public double calculateFee() {
		return super.calculateFee() + regularFee;
	}
}
