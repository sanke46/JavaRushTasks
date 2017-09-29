package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    public final int number;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
             order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if(!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
            }
            new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e){
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }

}