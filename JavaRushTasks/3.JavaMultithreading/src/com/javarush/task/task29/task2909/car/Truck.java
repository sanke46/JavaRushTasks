package com.javarush.task.task29.task2909.car;

/**
 * Created by ilafedoseev on 04/07/2017.
 */
public class Truck extends Car {

    private static final int MAX_TRUCK_SPEED = 80;

    public Truck(int numberOfPassengers) {
        super(1, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
