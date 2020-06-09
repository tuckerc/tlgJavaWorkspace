package com.transportation;

public class Car extends Vehicle {
    // INSTANCE VARIABLES
    private String make;
    private String model;

    // CONSTRUCTORS
    public Car(String vin) {
        super(vin);
    }

    public Car(String vin, String make, String model) {
        this(vin);
        setMake(make);
        setModel(model);
    }

    // BUSINESS METHODS
    public void moveTo(String destination) {
        System.out.println(getMake() + " " + getModel() + " moving to " + destination);
    }

    // ACCESSOR METHODS
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}