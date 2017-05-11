package com.javarush.task.task24.task2413;

/**
 * Created by ilafedoseev on 11.05.17.
 */
public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public BaseObject(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    abstract void move();

    abstract void draw(Canvas canvas);

    public boolean isIntersec(BaseObject o) {
        double Xdist = x - o.x;
        double Ydist = y - o.y;
        double hit = Math.sqrt(Xdist * Xdist + Ydist * Ydist);
        double hit2 = Math.max(radius,o.radius);
        return hit <= hit2;

    }

    //getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    //setter
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
