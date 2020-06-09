package com.hr;

public class Employee {
    // INSTANCE VARIABLES
    private String name;

    // CONSTRUCTORS
    public Employee(String name) {
        this.name = name;
    }

    // BUSINESS METHODS
    public void goToWork() {
        // TODO: create an instance of Car with all three properties: vin, make, model

        // TODO: call moveTo() on the Car object, passing "West Seattle" for the destination


        System.out.println("Arrived at work");
    }

    // ACCESSOR METHODS
    public String getName() {
        return name;
    }
}