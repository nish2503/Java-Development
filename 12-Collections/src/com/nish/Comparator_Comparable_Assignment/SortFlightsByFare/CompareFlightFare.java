package com.nish.Comparator_Comparable_Assignment.SortFlightsByFare;

import java.util.*;

public class CompareFlightFare {
	public static void main(String[] args) {
		List<Flight> list = new ArrayList<>();
		
		list.add(new Flight("Indigo", 5000));
		list.add(new Flight("AirIndia", 8000));
		list.add(new Flight("SpiceJet", 7000));
		list.add(new Flight("Vistara", 3000));
		
		Collections.sort(list, new FlightComparator());
		
		for(Flight f:list) {
			System.out.println(f);
		}
	}
}
