package com.javarush.task.task21.task2113;

/**
 * Created by ilafedoseev on 30.03.17.
 */
public class Horse {

    public String name;
    public double speed;
    public double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move(){
        distance += speed * Math.random();
    }

    public void print(){
        for (int i = 0; i < Math.floor(distance); i++) {
            System.out.print(".");
        }

        System.out.println(name);
    }

    // ==== Get methods ====

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    // ==== Set methods ====

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
