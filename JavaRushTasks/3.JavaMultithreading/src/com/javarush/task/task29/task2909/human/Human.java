package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private List<Human> children = new ArrayList<>();
    private int id;
    protected int age;
    protected String name;
//    protected int course;

    protected Size size;

    private BloodGroup bloodGroup;

    public class Size {
        public int height, weight;

        public Size(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human() {
    }

    public void setBloodGroup(BloodGroup bg) {
       this.bloodGroup = bg;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(boolean isSoldier) {
//        this.isSoldier = isSoldier;
        this.id = nextId;
        nextId++;
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human){
         children.add(human);
    }

    public void removeChild(Human human){
        children.remove(human);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.printf("%s: %s\n", getPosition(), name);
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {

    }
}