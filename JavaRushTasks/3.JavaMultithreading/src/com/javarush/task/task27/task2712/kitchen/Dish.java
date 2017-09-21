package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringBuilder strB = new StringBuilder();
        for (Dish d : Dish.values()) {
            strB.append(d).append(" ");
        }
        return strB.toString();
    }

}
