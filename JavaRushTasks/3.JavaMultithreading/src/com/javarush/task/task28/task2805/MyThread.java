package com.javarush.task.task28.task2805;

/**
 * Created by ilafedoseev on 05/08/2017.
 */
public class MyThread extends Thread{

    private static int property = 0;

    public MyThread() {
        this.setPriority(init());
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(init());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(init());
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(init());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(init());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(init());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(init());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(init());
    }

    private int init(){
        property++;

        if (property > Thread.MAX_PRIORITY) {
           property = 1;
        }

        return property;
    }

}
