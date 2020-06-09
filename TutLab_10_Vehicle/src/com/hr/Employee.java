package com.hr;

import com.transportation.Car;
import com.transportation.DestinationUnreachableException;

public class Employee {
    // INSTANCE VARIABLES
    private String name;

    // CONSTRUCTORS
    public Employee(String name) {
        this.name = name;
    }

    // BUSINESS METHODS
    public void goToWork() {
        // DONE: create an instance of Car with all three properties: vin, make, model
        Car vinMakeModelCar = new Car("1242342asdfasdf", "Toyota", "Corola");

        // DONE: call moveTo() on the Car object, passing "West Seattle" for the destination
        try {
            vinMakeModelCar.moveTo("West Seattle");
            System.out.println("Arrived at work");
        } catch (DestinationUnreachableException e) {
            e.printStackTrace();
        }
    }

    // ACCESSOR METHODS
    public String getName() {
        return name;
    }
}