package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilafedoseev on 28.04.17.
 */
public class Snake {

    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y){
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x,y));
        isAlive = true;

    }

    public Snake() {

    }

    public void run(){}

    public void print(){}

    public List<SnakeSection> getSections(){
        return sections;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public SnakeDirection getDirection(){
        return direction;
    }

    public void setDirection(SnakeDirection direction){
        this.direction = direction;
    }

    public int getX(){
        return sections.get(0).getX();
    }

    public int getY(){
        return sections.get(0).getY();
    }

    public void move(){
        if(isAlive){
            if(direction.equals(SnakeDirection.UP)){
                move(0,-1);
            } else if(direction.equals(SnakeDirection.RIGHT)){
                move(1,0 );
            } else if(direction.equals(SnakeDirection.DOWN)){
                move(0,1);
            } else if(direction.equals(SnakeDirection.LEFT)){
                move(-1 ,0);
            }
        }
    }

    public void move(int x, int y){

    }

    public void checkBorders(SnakeSection head){
        if (head.getX() < 0 || head.getX() > Room.game.getWidth() - 1)
            isAlive = false;
        if (head.getY() < 0 || head.getY() > Room.game.getHeight() - 1)
            isAlive = false;
    }

    public void checkcheckBody(SnakeSection head){
        if (sections.contains(head)){
            isAlive = false;
        }
    }
}
