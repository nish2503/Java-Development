package com.nish.Abstraction.Model;

public class Taxi extends Transport {
    private double distance;
    private double time;
    private double pricePerKm;
    private double pricePerMinute;

    public Taxi(String routeId, double baseFare, double distance, double time, double pricePerKm, double pricePerMinute) {
        super(routeId, baseFare);
        this.distance = distance;
        this.time = time;
        this.pricePerKm = pricePerKm;
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    protected double calculateFare() {
        return baseFare + (distance * pricePerKm) + (time * pricePerMinute);
    }
}