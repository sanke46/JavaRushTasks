package com.javarush.task.task26.task2601;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] arr = {13, 8, 15, 5, 17};
//        for (Integer integer : sort(arr)) {
//            System.out.println(integer);
//        }
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int medium;

        //проверка массива
        if(array.length == 0){
            return new Integer[]{};
        }

        // медиан
        if(array.length % 2 == 0){
            medium = (array[array.length/2] + array[(array.length/2) - 1])/2;
        } else {
            medium = array[array.length/2];
        }

        //сортировка
        Comparator<Integer> comparatorMedium = Comparator.comparing(o -> Math.abs(o - medium));

        Arrays.sort(array,comparatorMedium);
        return array;
    }
}
