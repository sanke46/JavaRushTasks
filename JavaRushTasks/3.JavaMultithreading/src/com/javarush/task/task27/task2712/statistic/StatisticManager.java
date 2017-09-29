package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();

    private StatisticManager() {
    }

    public static StatisticManager getOurInstance() {
        return ourInstance;
    }

    public void register(EventDataRow e) {

    }

}
