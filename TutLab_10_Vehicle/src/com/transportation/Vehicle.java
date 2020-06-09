package com.transportation;

public abstract class Vehicle {
    // INSTANCE VARIABLES
    private String vin;

    // CONSTRUCTORS
    public Vehicle(String vin) {
        this.vin = vin;
    }

    // BUSINESS METHODS
    public abstract void moveTo(String destination) throws DestinationUnreachableException;
}