package com.nish.Comparator_Comparable_Assignment.SortFlightsByFare;
import java.util.Comparator;

public class FlightComparator implements Comparator<Flight> {
	public int compare(Flight f1, Flight f2) {
		
		return Double.compare(f1.fare, f2.fare);
	}
}
