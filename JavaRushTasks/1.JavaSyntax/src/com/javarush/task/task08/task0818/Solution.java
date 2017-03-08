package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {

        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иван1",100);
        map.put("Иван2",200);
        map.put("Иван3",300);
        map.put("Иван4",400);
        map.put("Иван5",500);
        map.put("Иван6",600);
        map.put("Иван7",700);
        map.put("Иван8",800);
        map.put("Иван9",900);
        map.put("Иван10",1000);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {

        //напишите тут ваш код
        for(Iterator< Map.Entry<String , Integer>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() < 500){
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());
    }
}