package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ilafedoseev on 06/07/2017.
 */
public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;

        try {
            while (true) {
                map.put(i+"","Some text for " + i);
                i++;
                Thread.sleep(500);
            }

        } catch (Exception e){
            System.out.println("[" + e + "]" +" thread was terminated");
        }
    }
}
