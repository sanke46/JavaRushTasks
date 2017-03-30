package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilafedoseev on 30.03.17.
 */
public class Hippodrome {

    private static List<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(horses);
        Horse H1 = new Horse("h1", 3,0);
        Horse H2 = new Horse("h2", 3,0);
        Horse H3 = new Horse("h3", 3,0);

        horses.add(H1);
        horses.add(H2);
        horses.add(H3);

        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        for (Horse arr : horses){
            arr.move();
        }
    }

    public void print(){
        for (Horse arr : horses){
            arr.print();
        }

        for (int i = 0; i < 10 ; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);

        for (Horse arr : horses) {
            if(arr.getDistance() > winner.getDistance()){
                winner = arr;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
