package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {

    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {}

    public static StatisticManager getOurInstance() {
        return ourInstance;
    }

    private class StatisticStorage {
        private Map<EventType,List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            storage.put(EventType.COOKED_ORDER, new ArrayList<EventDataRow>());
            storage.put(EventType.SELECTED_VIDEOS, new ArrayList<EventDataRow>());
            storage.put(EventType.NO_AVAILABLE_VIDEO, new ArrayList<EventDataRow>());
        }
    }

    public void register(EventDataRow e) {}
}
