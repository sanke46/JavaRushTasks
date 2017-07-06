package com.javarush.task.task26.task2603;

import java.util.Comparator;
import java.util.Objects;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T>{

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(Object o1, Object o2) {
            int result = 0;

            for (Comparator o : comparators) {
                result = o.compare(o1, o2);
                if(result != 0){
                    break;
                }
            }
            return result;
        }
    }
}
