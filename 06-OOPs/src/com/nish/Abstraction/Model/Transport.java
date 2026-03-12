package com.nish.Abstraction.Model;

public abstract class Transport {
	private String routeId;
	protected double baseFare;
	
	public Transport(String routeId, double baseFare){
		this.routeId = routeId;
		this.baseFare = baseFare;
	}
	
	protected abstract double calculateFare();
	
	public void printTicket() {
		double finalFare = calculateFare();
        System.out.println("Route ID: " + routeId);
        System.out.println("Base Fare: " + baseFare);
        System.out.println("Total Fare: " + finalFare);
	}

}
