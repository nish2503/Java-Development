package com.nish.Comparator_Comparable_Assignment.SortFlightsByFare;

public class Flight {
	String airline;
	double fare;
	
	Flight(String airline, double fare){
		this.airline = airline;
		this.fare = fare;
	}
	
	public String toString() {
		return airline + " " + fare;
	}
}
