package com.javarush.task.task24.task2413;

import java.util.List;

/**
 * Created by ilafedoseev on 10.05.17.
 */
public class Arkanoid {

    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    public static Arkanoid game;

    public static void main(String[] args) {
        
    }

    public Arkanoid(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void move(){

    }

    public void run(){

    }

    // getter
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Ball getBall() {
        return ball;
    }

    public Stand getStand() {
        return stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    //setter
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
