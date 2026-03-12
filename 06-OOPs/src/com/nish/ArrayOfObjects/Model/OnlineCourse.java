package com.nish.ArrayOfObjects.Model;

public class OnlineCourse extends Course {
	private double onlineFee;
	private double platformFee;
	
	public OnlineCourse(String courseId, String courseName, double onlineFee, double platformFee){
		super(courseId, courseName);
		this.onlineFee = onlineFee;
		this.platformFee = platformFee;
	}
	
	@Override 
	public double calculateFee() {
		return super.calculateFee() + onlineFee + platformFee;
	}
}
