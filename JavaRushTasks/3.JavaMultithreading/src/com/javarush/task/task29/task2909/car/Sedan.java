package com.javarush.task.task29.task2909.car;

/**
 * Created by ilafedoseev on 04/07/2017.
 */
public class Sedan extends Car {

    private static final int MAX_SEDAN_SPEED = 120;

    public Sedan( int numberOfPassengers) {
        super(2, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
