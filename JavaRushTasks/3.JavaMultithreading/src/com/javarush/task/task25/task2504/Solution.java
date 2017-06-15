package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for(Thread x : threads){
            Thread.State treadstate = x.getState();
            switch (treadstate){
                case NEW:
                    x.start();
                    break;
                case TERMINATED:
                    System.out.println(x.getPriority());
                    break;
                case WAITING:;
                case TIMED_WAITING:;
                case BLOCKED:
                    x.interrupt();
                    break;
                case RUNNABLE:
                    x.isInterrupted();

            }
        }
    }

    public static void main(String[] args) {
    }
}
