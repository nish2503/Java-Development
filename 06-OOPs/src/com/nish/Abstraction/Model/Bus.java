package com.nish.Abstraction.Model;

public class Bus extends Transport {
	private double distance;
	private double pricePerKm;
	public Bus(String routeId, double baseFare, double distance, double pricePerKm){
		super(routeId, baseFare);
		this.distance = distance;
		this.pricePerKm = pricePerKm;
	}
	
	@Override 
	protected double calculateFare() {
		return baseFare + (distance*pricePerKm);
	}
}
