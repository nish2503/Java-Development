package com.nish.Abstraction.Model;

public class Metro extends Transport {
	private double stations;
	private double pricePerStation;
	public Metro(String routeId, double baseFare, double stations, double pricePerStation){
		super(routeId, baseFare);
		this.stations = stations;
		this.pricePerStation = pricePerStation;
	}
	
	@Override 
	protected double calculateFare() {
		return baseFare + (stations*pricePerStation);
	}
}
